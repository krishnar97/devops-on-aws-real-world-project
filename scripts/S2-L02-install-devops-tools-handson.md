# S2-L02: Install the DevOps Tools on the Server (Hands-On)

**Duration:** ~8–10 min
**Goal:** On the Ubuntu EC2 instance, install Docker, Terraform, AWS CLI, configure AWS
access, then install kubectl and Helm.
**Style:** Spoken narration — keep it very simple.
**Assumes:** You are already SSH'd into the `booknova-ubuntu-01` server from S2-L01.
**Commands:** All commands are in
[S2-L02-install-commands.md](S2-L02-install-commands.md). Keep it open and follow the
numbered sections.

---

## Intro

"In this session we will install all the required software. I have consolidated all the
required commands in the commands file — you just need to follow that. Let's start."

---

## Part A — Docker

"Let's start with Docker. Run the `curl` command to download the install script. Then
run `sh` to install it. Then run `docker version` to check.

After that, run the two lines to add our user to the docker group, so we can use Docker
without `sudo`. (Section 1 in the commands file.)"

---

## Part B — Terraform

"Next, Terraform. Copy the commands from section 2 and run them. Then run
`terraform version` to check."

---

## Part C — AWS CLI

"Next, the AWS CLI. Copy the commands from section 3 and run them. Then run
`aws --version` to check."

---

## Part D — Configure AWS access

"Now connect it to AWS. First we create an access key in the AWS console.

- Click your **account name** at the top-right, then **Security credentials**.
- Scroll down to **Access keys** and click **Create access key**.
- Choose **Command Line Interface (CLI)**, tick the confirmation checkbox, and click
  **Next**.
- (Optional) add a description tag, then click **Create access key**.
- Now you see the **Access key ID** and the **Secret access key**. Click **Show** to
  see the secret. Copy both — paste them into a text file on your machine so you have
  them for the next step. You can also click **Download .csv file** to save them.

Important: this is the **only time** the secret key is shown. Keep that text file safe,
and delete the key from AWS when you no longer need it.

Now run `aws configure` from section 4 and paste the values:
- **AWS Access Key ID** — from your text file
- **AWS Secret Access Key** — from your text file
- **Default region name** — `ap-south-1` (Mumbai)
- **Default output format** — `json`

Then run `aws s3 ls` to check. Our S3 buckets show up, so it works."

---

## Part E — kubectl

"Next, kubectl. Copy the commands from section 5 and run them. Then run
`kubectl version --client` to check."

---

## Part F — Helm

"Last, Helm. Copy the command from section 6 and run it. Then run `helm version` to
check.

That's it — Docker, Terraform, AWS CLI, kubectl, and Helm are all installed."

---

## Cleanup reminder

"When you're done for the day, go to the EC2 console and **Stop** the instance so you
don't pay for it. Your tools stay on the disk for next time."

## Placeholders
- Access Key ID / Secret Access Key → from your admin user's **Create access key**
- region → `ap-south-1` (Mumbai) or whichever region you work in
