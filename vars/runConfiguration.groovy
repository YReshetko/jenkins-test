def call(){
    def cases = ["develop", "feature", "release", "pullrequest"]
    def random = new Random()
    return cases[random.nextInt(4)]
}