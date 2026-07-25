# S3-L16: Walk the App and Change the Reviews Version (Hands-On, Praveen Style)

**Section:** REAL PROJECT #1 — Containerization Microservices Project
**Duration:** ~7 min
**Goal:** Explore the BookNova pages, then switch the reviews service version through the
`.env` file and see the change live.
**Files:** [app/docker-compose.yaml](../app/docker-compose.yaml)

---

## Intro

"Alright, let's walk through the app, then change one thing and watch it update. This is how
we see the different service versions in action."

---

## Part A — walk through the app

"On the product page:

- Open a book — you can see **Book Details** and **Book Reviews**.
- You can also **sign in** with a username and password — it's a simple demo sign-in.
- Sign out again. Everything works."

---

## Part B — create the .env file

"The version of the reviews service is controlled by an environment variable. There's a
sample file for it in the `src` folder:

```bash
cd app
cp .env.sample .env
```

We copy the sample to a real `.env` file — that's the file docker compose reads."

---

## Part C — change the version

"Now edit the file and change the version:

```bash
vi .env
```

Change the reviews version from **1** to **2** (or **3**). Save and exit.

- **Version 1** — reviews with no stars.
- **Version 2** — reviews with **black** stars.
- **Version 3** — reviews with **red** stars."

---

## Part D — apply and check

"Bring the app up again so it picks up the new version:

```bash
docker compose up -d
```

Refresh the browser. Now the reviews show stars — the rating changed because we switched
the service version. Try each version and watch the stars change."

---

## Recap

"So:

- The app has **productpage, details, reviews** working together.
- Copy `.env.sample` to `.env`.
- Change the **reviews version** (1, 2, or 3).
- `docker compose up -d` and refresh — the stars change live."

---

## Placeholders

- None.
