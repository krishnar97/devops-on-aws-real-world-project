"""
BookNova - productpage service

A small Flask web app that shows a book's details and reviews. In the full project
this page calls the details and reviews microservices; here we keep a simple,
self-contained version so we can focus on containerizing it with Docker.
"""

import os

from flask import Flask, render_template, jsonify

app = Flask(__name__)

# The book shown on the product page.
BOOK = {
    "title": "The Comedy of Errors",
    "author": "William Shakespeare",
    "year": 1595,
    "pages": 200,
    "language": "English",
    "publisher": "BookNova Press",
}

# A few sample reviews.
REVIEWS = [
    {"reviewer": "Reviewer1", "rating": 5, "text": "An unbelievable masterpiece!"},
    {"reviewer": "Reviewer2", "rating": 4, "text": "Absolutely fun and entertaining."},
]


@app.route("/health")
def health():
    """Simple health check used by Docker and Kubernetes."""
    return jsonify(status="ok"), 200


@app.route("/")
def index():
    """Render the product page for our book."""
    return render_template("index.html", book=BOOK, reviews=REVIEWS)


if __name__ == "__main__":
    # Port can be overridden with the PORT env var (defaults to 9080).
    port = int(os.environ.get("PORT", "9080"))
    app.run(host="0.0.0.0", port=port)
