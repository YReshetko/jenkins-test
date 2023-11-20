def call(config){
    switch(config) {
        case "develop":
            runDevelop()
        break
        case "feature":
            runFeature()
        break
        case "release":
            runRelease()
        break
        case "pullrequest":
            runPullRequest()
        break
    }
}