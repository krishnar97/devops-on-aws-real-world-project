# S3-L12: Understand the Dockerfiles of Our Book Project (Hands-On, Praveen Style)

**Section:** REAL PROJECT #1 — Containerization Microservices Project
**Duration:** ~10 min
**Goal:** Understand our BookNova project and quickly walk through the Dockerfile of
each microservice — no AI, we explain it in our own simple style.
**Files:** [app/](../app/) — `productpage/` (Python), `details/` (Ruby),
`ratings/` (Node.js), `reviews/` (Java).

---

## Intro — our project

"Okay guys, before we containerize anything, let me show you *what* we are actually
building. This is our **BookNova** application, and it is a **microservices** app. That
means it is not one big program — it is several small services, each doing one job, and
each written in a different language. That's why it's a great real-world example.

Look at the diagram. A request comes in and hits the **productpage**. The productpage is
the front page — it calls the other services to build the page:

- **productpage** → the web front end — **Python**
- **details** → book details like author, pages, ISBN — **Ruby**
- **reviews** → the reviews (v1, v2, v3) — **Java**
- **ratings** → the star ratings — **Node.js**

Four services, four different languages. Now, each service needs to run in its own
container. And to build a container we need a **Dockerfile**. So we have four
Dockerfiles. That's exactly why some people just paste them into AI. But we won't — once
you know the pattern, all four are basically the same recipe."

---

## The one pattern behind every Dockerfile

"Before we look at each file, remember these building blocks. *Every* Dockerfile, in any
language, follows the same idea:

1. `FROM` — pick a base image (the language runtime)
2. `WORKDIR` — set a folder inside the container
3. `COPY` — copy our code in
4. `RUN` — install dependencies while building
5. `EXPOSE` — document the port
6. `USER` — run as non-root for security
7. `CMD` — the command that starts the app

Only the language-specific bits change — `pip` vs `npm` vs `bundle` vs `javac`. That's
it. Let's go through them quickly."

---

## 1. productpage — Python

File: [app/productpage/Dockerfile](../app/productpage/Dockerfile)

"Base is `python:3.13-slim`. We copy `requirements.txt` first, `pip install` our
packages, then copy the code, and start it with **gunicorn** (a production Python
server) on port 9080. High level: *Python image → install with pip → run with
gunicorn*."

---

## 2. details — Ruby

File: [app/details/Dockerfile](../app/details/Dockerfile)

"Same recipe, different language. Base is `ruby:3.3-slim`, we copy the `details.rb`
file, expose port 7070, and start it with `ruby details.rb`. High level: *Ruby image →
copy code → run with ruby*. Notice there's nothing scary here — it's the same shape as
Python."

---

## 3. ratings — Node.js

File: [app/ratings/Dockerfile](../app/ratings/Dockerfile)

"Base is `node:22-slim`. Here we copy `package.json` first and run `npm install` — this
is the Node version of installing dependencies. Then we copy the code and start it with
`node ratings.js` on port 9080. High level: *Node image → install with npm → run with
node*."

---

## 4. reviews — Java (multi-stage)

File: [app/reviews/Dockerfile](../app/reviews/Dockerfile)

"This one is a little different, and it teaches one new idea: a **multi-stage build**.

Java is a **compiled** language — we first need a big **JDK** to compile the code, but
to *run* it we only need a small **JRE**. So we use two stages:

- **Stage 1 (build):** use the JDK image, `javac Reviews.java` to compile it.
- **Stage 2 (runtime):** use the small JRE image, and copy *only* the compiled result
  from stage 1.

Why bother? Because the final image stays **small** — it doesn't carry the whole
compiler around. High level: *build stage compiles → runtime stage only ships the
result*. This is a very common pattern for Java, Go, and C++."

---

## Build them

"To build any service, go into its folder and run `docker build`. For example:

```sh
docker build -t booknova-productpage ./app/productpage
docker build -t booknova-details     ./app/details
docker build -t booknova-ratings     ./app/ratings
docker build -t booknova-reviews     ./app/reviews
```

Each one reads its own Dockerfile and produces an image. In the next lesson we'll wire
them together with **docker compose** and run the whole BookNova app at once."

---

## Recap

- Our app = **4 microservices**, 4 languages, so **4 Dockerfiles**.
- Every Dockerfile is the **same 7-step recipe**; only the install/run commands differ.
- Java needs a **multi-stage build** because it's compiled — build big, ship small.
- We don't need AI to read these — we understand the pattern now.
