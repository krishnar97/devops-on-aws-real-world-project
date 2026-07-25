# S3-L17: Create an ECR Repository and Push the Image (Hands-On, Praveen Style)

**Section:** REAL PROJECT #1 — Containerization Microservices Project
**Duration:** ~9 min
**Goal:** Create a repository in Amazon ECR, log in from the EC2 machine, then push our
BookNova image so a Kubernetes cluster can pull it later.
**Files:** [app/docker-compose.yaml](../app/docker-compose.yaml)

---

## Intro

"Okay, in this step we create a **repository** for our image. Our image needs to live in a
proper image store, and on AWS that store is **ECR** — Elastic Container Registry. Let's
create one and push to it."

---

## Good to know — what is ECR?

"Quick one: **ECR (Elastic Container Registry)** is AWS's private Docker image store. Think
of it like **Docker Hub, but inside your AWS account**.

- It **holds our built images** so servers don't have to rebuild them.
- It's **private and secure** — only your AWS account and roles can pull, using IAM.
- Later, our **EKS (Kubernetes)** cluster pulls the image straight from ECR to run it.
- A **repository** is one named bucket of images (e.g. `booknova-productpage`), and each
  image gets a **tag** like `latest` or a version number.

So: we build once, push to ECR, and everything else pulls from there."

---

## Part A — create the ECR repository

"In the AWS Console:

1. Go to **ECR** (Elastic Container Registry).
2. **Create repository**.
3. Name it — for example `booknova-productpage`.
4. Leave the defaults and **Create repository**.

Now we have a repository, and you can see it in the list."

---

## Part B — get the push commands

"Open the repository and click **View push commands**. AWS gives you the exact commands for
your account and region. They look like this:

```bash
aws ecr get-login-password --region <REGION> | \
  docker login --username AWS --password-stdin <ACCOUNT-ID>.dkr.ecr.<REGION>.amazonaws.com
```

Run that first one — it logs Docker into ECR. You should see **login success**."

---

## Part C — tag and push

"Now tag our image with the repository address and push it:

```bash
docker tag <LOCAL-IMAGE>:latest \
  <ACCOUNT-ID>.dkr.ecr.<REGION>.amazonaws.com/<REPO-NAME>:latest

docker push <ACCOUNT-ID>.dkr.ecr.<REGION>.amazonaws.com/<REPO-NAME>:latest
```

The push uploads each layer. When it finishes, refresh the ECR repository and you'll see the
image sitting there with the `latest` tag."

---

## Recap

"So:

- Create a **repository** in **ECR**.
- Use **View push commands** to log in: `aws ecr get-login-password ... | docker login`.
- **Tag** the local image with the repo address, then **push** it.
- The image is now in ECR, ready for Kubernetes to pull."

---

## Placeholders

- `<REGION>` — your AWS region (e.g. `ap-south-1`).
- `<ACCOUNT-ID>` — your 12-digit AWS account ID.
- `<REPO-NAME>` — the ECR repository name.
- `<LOCAL-IMAGE>` — the local image name from docker compose (e.g. `app-productpage`).
