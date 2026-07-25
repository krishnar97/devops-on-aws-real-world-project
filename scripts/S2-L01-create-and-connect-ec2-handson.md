# S2-L01: Create and Connect to an EC2 Instance (Hands-On)

**Duration:** ~3–4 min
**Goal:** Launch an Ubuntu EC2 instance and connect to it over SSH.
**Style:** Spoken narration — talk through it naturally while doing it on screen.

---

## Part A — Create the EC2 instance

"Let's create our server. First, look at the top-right corner of the screen. It should
say **Asia Pacific, Mumbai**. We always work in the Mumbai region. Confirm that first.

In the search bar, type **EC2** and open it. This is where we create our servers. Click
the orange **Launch instance** button.

First it asks for a name. I'll call mine `booknova-ubuntu-01`. I use the project name
`booknova` so it's easy to recognize later.

Next, pick the operating system. Scroll and choose **Ubuntu**. Keep the default Ubuntu
version.

Next is the instance type — the size of the machine. Choose **t2.medium**. This gives
us enough power to run Docker later.

Now the key pair. This is the key we use to log into the server. Click **Create new key
pair**, name it `booknova-key`, keep **RSA** and **.pem**, and click create. It
downloads a file to your machine. Keep this file safe — it's the only key to your
server.

In network settings, use the default network and make sure it creates a security group
that allows **SSH on port 22**. That's the door we use to connect.

For storage, the default is 8 GB. Bump it up to **20 GB**, because Docker images need
space.

That's everything. Click **Launch instance**, then **View all instances**. Wait until
the state says **Running** and status checks show **2 out of 2 passed**. Our server is
up."

---

## Part B — Connect over SSH

"Now let's get inside this server. Click on the instance and copy its **Public IPv4
address** — this is the internet address of our machine.

Open your terminal and go into the folder where the key file downloaded — for me it's
Downloads:

```sh
cd ~/Downloads
```

First, lock down the key. If it's too open, SSH will complain:

```sh
chmod 400 booknova-key.pem
```

Now connect. Type `ssh`, then `-i` and your key file, then `ubuntu` — the username for
Ubuntu servers — the `@` symbol, and paste the public IP:

```sh
ssh -i booknova-key.pem ubuntu@<PUBLIC_IP>
```

The first time it asks 'are you sure you want to connect' — type **yes**.

Now the prompt changed. It says `ubuntu@ip-...`. That means we're no longer on our
laptop — we're **inside the cloud server**."

---

## Part C — Verify internet

"Let's check the server can reach the internet. Run:

```sh
sudo apt update
```

It connects out and reads the package lists — so internet works. This machine is now
ready. In the next lecture we start installing our DevOps tools, starting with Docker."

---

## Cleanup reminder

"One last thing — this machine costs money while it runs. When you're done for the day,
go back to the EC2 console and **Stop** the instance. You can start it again next time.
If you're completely finished, then **Terminate** it."

## Placeholders
- `<PUBLIC_IP>` → your instance's public IPv4
- key path → wherever `booknova-key.pem` downloaded
