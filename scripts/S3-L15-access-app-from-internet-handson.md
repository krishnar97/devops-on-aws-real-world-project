# S3-L15: Access BookNova from the Internet (Hands-On, Praveen Style)

**Section:** REAL PROJECT #1 — Containerization Microservices Project
**Duration:** ~6 min
**Goal:** Open the right port in the EC2 security group and reach our running app from the
browser using the public IP.
**Files:** [app/docker-compose.yaml](../app/docker-compose.yaml)

---

## Intro

"Okay, our app is running inside the container on the EC2 machine. Right now we can only
reach it with `localhost` on the server itself. Let's open it up so we can hit it from our
own browser over the internet."

---

## Part A — open the port in the security group

"The traffic is blocked by the **security group** — that's the firewall around our EC2.
Let's open the app port:

1. AWS Console → **EC2** → **Instances** → click our instance.
2. Go to the **Security** tab → click the **security group**.
3. **Edit inbound rules** → **Add rule**.
4. Type = **Custom TCP**, Port = **9080**, Source = **Anywhere-IPv4** (`0.0.0.0/0`).
5. **Save rules**.

That opens port 9080 to the world so the browser can reach productpage."

---

## Part B — get the public IP

"Now we need the address of the machine:

1. Back on the instance page, copy the **Public IPv4 address**.
2. Use the plain IP — not the private one."

---

## Part C — open it in the browser

"In your browser go to:

```
http://<PUBLIC-IP>:9080/productpage
```

And there it is — our BookNova page is live on the internet. We'll dig into the pages in
the next lesson."

---

## Recap

"So:

- The **security group** blocks traffic by default.
- Add an inbound rule for **TCP 9080** from anywhere.
- Grab the **public IP** and open `http://<PUBLIC-IP>:9080/productpage`."

---

## Placeholders

- `<PUBLIC-IP>` — your EC2 instance's public IPv4 address.
