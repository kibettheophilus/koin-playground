import systems.danger.kotlin.*

danger(args) {
    onGitHub {
        // Work in progress check
        if (pullRequest.title.contains("WIP", true)) {
            warn("PR is classed as Work in Progress")
        }
    }
}
