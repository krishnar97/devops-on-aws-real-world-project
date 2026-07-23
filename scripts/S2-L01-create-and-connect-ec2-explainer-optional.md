# S2-L01 (OPTIONAL EXPLAINER): Understanding EC2, Key Pairs & Security Groups

**Duration:** ~4–5 min
**Type:** Optional concept video — record separately. Explains the "why" behind the
hands-on EC2 lecture.

---

## Hook

"In the hands-on we quickly launched a server. In this optional video, let me slow
down and explain **what actually happened** and **why** — so you truly understand it,
not just click buttons."

---

## What is EC2?

EC2 = **Elastic Compute Cloud**. It's simply a **computer that AWS rents to you**.
Instead of buying a laptop and keeping it on your desk, you rent one from Amazon; it
runs in their data center and you connect over the internet.

**Analogy:** Like renting a shop instead of buying a building — use it while you need
it, give it back when done, stop paying. That's why we always **stop/terminate** EC2
when finished, so we don't pay rent for an empty shop.

---

## The key terms

- **AMI** — the operating system image. We picked **Ubuntu** (Linux used everywhere
  in DevOps).
- **Instance type** — the *size* of the machine (CPU + RAM). We used `t2.medium`.
  - Why not the free `t2.micro`? Because we'll run Docker and build multiple images —
    the tiny machine runs out of memory. We spend a little for a comfortable machine,
    and it comes from our $200 credit.
- **Key pair** — the **digital key** to the front door. Without the `.pem` file nobody
  can log in — not even you. There's no "forgot password". Guard it.
- **Security group** — a **firewall / security guard** that decides which doors
  (ports) are open. We opened port **22** = the SSH door.

*(Whiteboard: laptop → internet → AWS box "EC2 Ubuntu" with a lock (key pair) and a
guard (security group) at port 22.)*

---

## What the connect commands mean

- `chmod 400 booknova-key.pem` → locks the key so only you can read it. Skip it and
  SSH throws an "unprotected private key" error (very common).
- `ssh -i booknova-key.pem ubuntu@<IP>` → `-i` = use this identity/key; `ubuntu` = the
  default username for Ubuntu servers; then the public IP.
- `sudo apt update` → refreshes the package list; we use it just to confirm internet
  works.

---

## Common errors explained

- **Permission denied (publickey)** → wrong username or wrong key file. Ubuntu uses
  `ubuntu@`.
- **UNPROTECTED PRIVATE KEY FILE** → you forgot `chmod 400`.
- **Connection times out** → security group isn't allowing port 22, or your network
  blocks SSH.

---

## In real production you'd...

We do **not** open SSH to the whole internet (`0.0.0.0/0`) in production. Instead:
- Restrict port 22 to a known **office IP**, or
- Use a **bastion host** or **AWS Systems Manager Session Manager** — no open SSH port
  at all.

For learning, open SSH is fine — but this is the interview-correct answer.
