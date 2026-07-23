# S2-L01: Create and Connect to an EC2 Instance (Hands-On)

**Duration:** ~3–4 min
**Goal:** Launch an Ubuntu EC2 instance and connect to it over SSH.
**Style:** Spoken narration — talk through it naturally while doing it on screen.

---

## Part A — Create the EC2 instance

"Alright guys, let's create our server. But before anything — look at the top-right
corner of the screen. It should say **Asia Pacific, Mumbai**. We're in India, so we
always work in the Mumbai region. Just confirm that first.

Okay, now in the search bar I'll type **EC2** and open it. This is the service where
we create our servers. I'll click this orange **Launch instance** button.

First it asks for a name. I'll call mine `booknova-ubuntu-01` — I'm using our project
name `booknova` so later it's easy to recognize.

Now it asks which operating system I want. I'll scroll and pick **Ubuntu**. We'll keep
the default Ubuntu version that's already selected.

Next is the instance type — this is basically the size of the machine. I'll choose
**t2.medium**. This gives us enough power to run Docker later without any trouble.

Now, very important — the key pair. This is the key we'll use to log into the server.
I'll click **Create new key pair**, give it the name `booknova-key`, keep it as **RSA**
and **.pem**, and click create. See, it downloaded a file to my machine. Keep this file
safe — this is the only key to your server.

Coming down to network settings — I'll let it use the default network, and I'll make
sure it creates a security group that allows **SSH on port 22**. That's the door we'll
use to connect.

Then storage — the default is 8 GB, but I'll bump it up to **20 GB**, because Docker
images will need some space.

That's everything. I'll click **Launch instance**... and give it a few seconds. Let me
click **View all instances**. Now we wait until the state says **Running** and the
status checks show **2 out of 2 passed**. There we go — our server is up."

---

## Part B — Connect over SSH

"Now let's get inside this server. I'll click on the instance and copy its
**Public IPv4 address** — this is the internet address of our machine.

I'll open my terminal, and go into the folder where that key file got downloaded —
for me it's Downloads:

```sh
cd ~/Downloads
```

Now one small thing first. If I try to use the key directly, SSH will complain it's
too open. So I'll lock it down:

```sh
chmod 400 booknova-key.pem
```

Now let's connect. I'll type `ssh`, then `-i` and my key file, then `ubuntu` — that's
the username for Ubuntu servers — the `@` symbol, and paste the public IP:

```sh
ssh -i booknova-key.pem ubuntu@<PUBLIC_IP>
```

First time it asks 'are you sure you want to connect' — I'll just type **yes**.

And look at that — my prompt has changed. It now says `ubuntu@ip-...`. That means we're
no longer on our laptop, we are now **inside the cloud server**. We made it."

---

## Part C — Verify internet

"Let me quickly check the server can reach the internet. I'll run:

```sh
sudo apt update
```

You can see it's connecting out and reading the package lists — so internet is working
perfectly. This machine is now ready, and in the next lecture we'll start installing
all our DevOps tools on it, starting with Docker."

---

## Cleanup reminder

"One last thing — this machine costs money while it runs. So when you're done studying
for the day, go back to the EC2 console and **Stop** the instance. You can start it
again next time. If you're completely finished, then **Terminate** it."

## Placeholders
- `<PUBLIC_IP>` → your instance's public IPv4
- key path → wherever `booknova-key.pem` downloaded
