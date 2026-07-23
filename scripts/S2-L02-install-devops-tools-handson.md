# S2-L02: Install the DevOps Tools on the Server (Hands-On)

**Duration:** ~8–10 min
**Goal:** On the Ubuntu EC2 instance, install Docker, Terraform, AWS CLI, configure AWS
access, then install kubectl and Helm.
**Style:** Spoken narration — talk through it naturally while doing it on screen.
**Assumes:** You are already SSH'd into the `booknova-ubuntu-01` server from S2-L01.

---

## Part A — Install Docker

"Alright, let's just start by installing **Docker** on our Ubuntu server. Docker is
what we'll use to build and run our containers.

Instead of typing every command by hand, I'll use a small **install script** — it's
faster and cleaner. You can open the script later and read exactly what it does; there
are no surprises in there.

I'll download the script onto the server, then run it:

```sh
curl -fsSL https://get.docker.com -o install-docker.sh
sh install-docker.sh
```

It runs step by step and installs Docker for us. You could also do this manually, or
on any OS you like — but the script just makes it painless.

When it's finished, let's confirm it worked:

```sh
docker version
```

Now one important thing — right now Docker needs `sudo` every time. Let's give our
`ubuntu` user permission to run Docker directly:

```sh
sudo usermod -aG docker ubuntu
newgrp docker
```

Copy that, run it, and now we can use Docker without `sudo`. "

---

## Part B — Install Terraform

"Next, we install **Terraform** — this is the tool we'll use to manage our
infrastructure as code.

Go to the Terraform website, open the Linux install instructions, and copy the command
block. I'll paste it into the terminal and run it:

```sh
wget -O - https://apt.releases.hashicorp.com/gpg | sudo gpg --dearmor -o /usr/share/keyrings/hashicorp-archive-keyring.gpg
echo "deb [signed-by=/usr/share/keyrings/hashicorp-archive-keyring.gpg] https://apt.releases.hashicorp.com $(lsb_release -cs) main" | sudo tee /etc/apt/sources.list.d/hashicorp.list
sudo apt update && sudo apt install terraform -y
```

While it runs you just wait — and if it ever pauses and asks you to confirm, just press
**Enter**. Once it's done, we've got Terraform ready to manage our infrastructure.

Check it:

```sh
terraform version
```

---

## Part C — Install the AWS CLI

"Now we install the **AWS CLI** on Ubuntu. Go to the AWS CLI page, pick **Linux**, and
copy the commands. I'm also installing `unzip` so we can unzip the installer:

```sh
sudo apt install unzip -y
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

Run it and wait a moment... and the AWS CLI is successfully set up on our Ubuntu
server."

---

## Part D — Configure AWS access (Admin user)

"Now we configure the **access key** so the server can talk to our AWS account.

In the AWS console, go to **Security credentials** for your **admin user**, and choose
**Create access key** → **Command Line Interface (CLI)**. Confirm, and optionally add a
description tag so you recognize it later.

Now you get an **Access key** and a **Secret access key**. Copy these somewhere safe —
I'll paste them into a temporary note file for a moment, and keep that file secure.

Back on the server, run:

```sh
aws configure
```

It asks four things:
- **AWS Access Key ID** — paste it
- **AWS Secret Access Key** — paste it
- **Default region name** — I'll use `ap-south-1` (Mumbai)
- **Default output format** — `json`

That's done. Let's confirm it can actually reach AWS by listing our S3 buckets:

```sh
aws s3 ls
```

And there they are — our S3 buckets show up, so the connection works."

---

## Part E — Install kubectl

"Next we install **kubectl** on the Ubuntu server — this is the tool we use to talk to
our Kubernetes cluster. Go to the Kubernetes website and copy the step-by-step Linux
commands; I've compiled them here for you:

```sh
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
kubectl version --client
```

---

## Part F — Install Helm

"Finally, we install **Helm** on Ubuntu. We need Helm to install charts later that help
us work with the cluster. You can read the brief on the Helm website; I'll just copy
their install script:

```sh
curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash
```

Copy that, paste it, run it... and now we have Helm. Let's confirm with a version
check:

```sh
helm version
```

That's it — our server now has all the core DevOps tools installed: Docker, Terraform,
the AWS CLI, kubectl, and Helm. In the next lecture we'll start using them."

---

## Cleanup reminder

"Same as before — when you're done for the day, go to the EC2 console and **Stop** the
instance so you're not paying for it. Your installed tools stay on the disk and will be
there when you start it again."

## Placeholders
- Access Key ID / Secret Access Key → from your admin user's **Create access key**
- region → `ap-south-1` (Mumbai) or whichever region you work in
