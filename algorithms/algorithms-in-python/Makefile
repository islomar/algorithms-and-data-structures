.DEFAULT_GOAL := help

help:  ## Show this help.
	@grep -E '^\S+:.*?## .*$$' $(firstword $(MAKEFILE_LIST)) | \
		awk 'BEGIN {FS = ":.*?## "}; {printf "%-30s %s\n", $$1, $$2}'

.PHONY: install
install: ## Install the right Python version and dependencies
	uv python install 3.13.7
	uv python pin 3.13.7
	uv sync --no-install-project

test: ## Run the test suite with uv
	uv run pytest

.PHONY: lint
lint: ## Lints the code format
	uv run ruff check --fix