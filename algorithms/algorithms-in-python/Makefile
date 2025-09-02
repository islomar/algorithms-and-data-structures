.DEFAULT_GOAL := help

help:  ## Show this help.
	@grep -E '^\S+:.*?## .*$$' $(firstword $(MAKEFILE_LIST)) | \
		awk 'BEGIN {FS = ":.*?## "}; {printf "%-30s %s\n", $$1, $$2}'

.PHONY: install
install: ## Install the right Python version and dependencies
	uv python install 3.13.7
	uv python pin 3.13.7
	uv sync --no-install-project

.PHONY: update-dependencies
update-dependencies: ## Update the dependencies
	uv lock --upgrade

.PHONY: add-dev-package
add-dev-package: ## Install a new package in the app. ex: make add-dev-package package=XXX
	uv add --dev $(package)

.PHONY: test
test: ## Run the test suite with uv
	uv run pytest

.PHONY: lint
lint: ## Lint the code format
	uv run ruff check --fix