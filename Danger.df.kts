import systems.danger.kotlin.*

danger(args) {
    onGitHub {
        // Work in progress check
        if (pullRequest.title.contains("WIP", false)) {
            warn("PR is classed as Work in Progress")
        }
    }
}