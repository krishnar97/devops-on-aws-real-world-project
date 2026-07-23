# S2-L02: Install the DevOps Tools on the Server (Hands-On)

**Duration:** ~8–10 min
**Goal:** On the Ubuntu EC2 instance, install Docker, Terraform, AWS CLI, configure AWS
access, then install kubectl and Helm.
**Style:** Spoken narration — talk through it naturally while doing it on screen.
**Assumes:** You are already SSH'd into the `booknova-ubuntu-01` server from S2-L01.
**Commands:** All copy-paste commands live in
[S2-L02-install-commands.md](S2-L02-install-commands.md). Keep that file open on screen
and run the numbered blocks as you narrate each part below.

---

## Part A — Install Docker

"Alright, let's just start by installing **Docker** on our Ubuntu server. Docker is
what we'll use to build and run our containers.

Instead of typing every command by hand, I'll use a small **install script** — it's
faster and cleaner. You can open the script later and read exactly what it does; there
are no surprises in there.

I'll download the script onto the server, then run it — grab the commands from
**section 1** of the commands file. It runs step by step and installs Docker for us.
You could also do this manually, or on any OS you like — but the script just makes it
painless.

When it's finished, `docker version` confirms it worked.

Now one important thing — right now Docker needs `sudo` every time. The next two lines
in section 1 add our `ubuntu` user to the docker group so we can run Docker directly
without `sudo`. "

---

## Part B — Install Terraform

"Next, we install **Terraform** — this is the tool we'll use to manage our
infrastructure as code.

Go to the Terraform website, open the Linux install instructions — I've already curated
those exact commands in **section 2** of the commands file. I'll paste that block and
run it.

While it runs you just wait — and if it ever pauses and asks you to confirm, just press
**Enter**. Once it's done, `terraform version` confirms we've got Terraform ready to
manage our infrastructure."

---

## Part C — Install the AWS CLI

"Now we install the **AWS CLI** on Ubuntu. Grab **section 3** of the commands file —
it installs `unzip`, downloads the installer, unzips it, and runs the installer. Run it
and wait a moment... and the AWS CLI is successfully set up on our Ubuntu server."

---

## Part D — Configure AWS access (Admin user)

"Now we configure the **access key** so the server can talk to our AWS account.

In the AWS console, go to **Security credentials** for your **admin user**, and choose
**Create access key** → **Command Line Interface (CLI)**. Confirm, and optionally add a
description tag so you recognize it later.

Now you get an **Access key** and a **Secret access key**. Copy these somewhere safe —
I'll paste them into a temporary note file for a moment, and keep that file secure.

Back on the server, run `aws configure` (see **section 4** of the commands file). It
asks four things:
- **AWS Access Key ID** — paste it
- **AWS Secret Access Key** — paste it
- **Default region name** — I'll use `ap-south-1` (Mumbai)
- **Default output format** — `json`

That's done. `aws s3 ls` confirms it can reach AWS — and there they are, our S3 buckets
show up, so the connection works."

---

## Part E — Install kubectl

"Next we install **kubectl** on the Ubuntu server — this is the tool we use to talk to
our Kubernetes cluster. Go to the Kubernetes website for the step-by-step Linux
commands — I've compiled them for you in **section 5** of the commands file. Run that
block, and `kubectl version --client` confirms it's installed."

---

## Part F — Install Helm

"Finally, we install **Helm** on Ubuntu. We need Helm to install charts later that help
us work with the cluster. You can read the brief on the Helm website; I'll just run
their install script from **section 6** of the commands file. Copy that, paste it,
run it... and now we have Helm. `helm version` confirms it.

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
