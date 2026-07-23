# S2-L02 (OPTIONAL EXPLAINER): Why These Five Tools?

**Duration:** ~4–5 min
**Type:** Optional concept video — record separately. Explains the "why" behind the
hands-on tool installation.

---

## Hook

"In the hands-on we installed five tools back to back. In this optional video, let me
explain **what each one is for** — so you understand the toolbox, not just the copy-paste
commands."

---

## The five tools and their jobs

- **Docker** — the **packaging + runtime** tool. It puts our app and everything it needs
  into a **container**, so it runs the same on any machine.
  - *Analogy:* a shipping container — pack once, run anywhere.
- **Terraform** — **infrastructure as code**. Instead of clicking around the AWS console
  to create VPCs, clusters, and servers, we **write it in files** and Terraform builds
  it for us — repeatable and version-controlled.
  - *Analogy:* a blueprint the robot builds from, every time identically.
- **AWS CLI** — the **remote control for AWS** from the terminal. Everything you can do
  in the console you can do with a command. Terraform and other tools also lean on the
  credentials it configures.
- **kubectl** — the **remote control for Kubernetes**. Once we have a cluster, `kubectl`
  is how we deploy, inspect, and manage what runs on it.
- **Helm** — the **package manager for Kubernetes** (think apt/npm, but for clusters).
  It installs whole applications as **charts** instead of dozens of YAML files by hand.

*(Whiteboard: laptop → AWS CLI → AWS account; Terraform → builds the cluster; kubectl +
Helm → talk to the cluster; Docker → builds the images that run on it.)*

---

## Why a script for Docker but not the others?

- The Docker install has several steps (repo keys, packages, service). The official
  `get.docker.com` script bundles them safely, so we use it to save time.
- Always glance at a script before running it. `get.docker.com` is the vendor's own —
  trusted. Never pipe a random internet script into your shell blindly.

---

## Why `usermod -aG docker ubuntu`?

Docker talks to a privileged background service, so by default only `root` (via `sudo`)
can use it. Adding our `ubuntu` user to the **docker group** lets us run `docker`
directly. `newgrp docker` just applies that group change without logging out.

> Security note: the docker group is effectively root-level. Fine on a personal lab
> server; be deliberate about it on shared/production machines.

---

## What `aws configure` actually stores

It writes two files in `~/.aws/`:
- `credentials` → your **access key** and **secret key**
- `config` → your default **region** and **output format**

The **secret key is shown only once** when you create it — that's why we copy it
carefully. If you lose it, you don't recover it, you create a new key and delete the old.

---

## Common errors explained

- **`docker: permission denied`** → you skipped the group step or didn't re-log /
  `newgrp docker`.
- **`Unable to locate credentials`** → you ran an AWS command before `aws configure`.
- **`kubectl ... connection refused`** → normal right now; we have no cluster yet. It
  starts working after we build the EKS cluster with Terraform.
- **`command not found` after install** → open a fresh shell so the new PATH is picked
  up.
