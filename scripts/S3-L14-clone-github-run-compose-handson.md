# S3-L14: Clone from GitHub and Run BookNova with Docker Compose (Hands-On, Praveen Style)

**Section:** REAL PROJECT #1 — Containerization Microservices Project
**Duration:** ~10 min
**Goal:** Set up GitHub, clone the project onto our EC2 machine, then run the whole app
with `docker compose` and check the containers.
**Files:** [app/docker-compose.yaml](../app/docker-compose.yaml)

---

## Intro

"Okay guys, the code lives on **GitHub**. So first we clone it to our EC2 machine, then we
run the whole app with docker compose. Let's go."

---

## Part A — create a GitHub token

"To clone, GitHub needs a **Personal Access Token** instead of a password. Let's make one:

1. GitHub → profile picture → **Settings**.
2. **Developer settings** → **Personal access tokens** → **Tokens (classic)**.
3. **Generate new token (classic)**, name it, tick the **repo** scope.
4. **Generate token** and **copy it to a text file** — GitHub shows it only once.

That token is our git password."

---

## Part B — clone the repo

"On the EC2 machine:

```bash
git clone https://github.com/<YOUR-USERNAME>/<YOUR-REPO>.git
cd <YOUR-REPO>
ls
```

When it asks for a username, type your GitHub **username**. When it asks for a password,
paste the **token**. You should now see our `app/` folder."

---

## Part C — run with docker compose

"Go to the app folder and bring everything up in the background:

```bash
cd app
docker compose up -d
```

Compose builds the image for each service — productpage, details, ratings, reviews — then
starts them. The first build takes a few minutes."

---

## Part D — check the containers

"See what's running:

```bash
docker ps
curl http://localhost:9080/health
```

All four should be up, and productpage answers on 9080. Our app is running."

---

## Recap

"So:

- Make a **token** on GitHub — it's our git password.
- `git clone` with **username + token**.
- `cd app` and `docker compose up -d` builds and starts all four services.
- `docker ps` and `curl` confirm it's running."

---

## Placeholders

- `<YOUR-USERNAME>` — your GitHub username.
- `<YOUR-REPO>` — your repository name.
