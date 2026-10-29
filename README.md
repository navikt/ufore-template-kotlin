# Mal for Team Uføres Kotlin-repositories

Beskrivelse av hva appen/tjenesten/tingen som lages i dette repositoryet gjør.

## Komme i gang
### Forutsetninger
- [JDK](https://jdk.java.net/)
- [Kotlin](https://kotlinlang.org/)
- [Gradle](https://gradle.org/) brukes som byggeverktøy og er inkludert i oppsettet

For hvilke versjoner som brukes, [se versjonsfilen](/gradle/libs.versions.toml)

### Følgende steg må gjennomføres for å få repoet ditt i kjørbar tilstand
- søk etter teksten `ufore-xxx-yyy` og erstatt med navnet på ditt repo. Her er en kommando som gjør det for deg på macOS dersom du står i repoets rotkatalog
```sh
repo_name=$(basename "$PWD") && grep -Irwl --null --exclude-dir=.git --exclude-dir=build -e 'ufore-xxx-yyy' . | xargs -0 env REPO_NAME="$repo_name" perl -pi -e 's/\bufore-xxx-yyy\b/$ENV{REPO_NAME}/g'
```
- gi repoet et eierskap på https://console.nav.cloud.nais.io/team/ufore/repositories
- på repoets side på GitHub → Settings → Secrets and variables → Actions
  - ny repository **variabel** `TEAM_UFORE_CLIENT_ID`. Verdien hentes fra https://github.com/organizations/navikt/settings/apps/team-ufore
  - ny repository **secret** `SLACK_INCOMING_WEBHOOK_URL`. Verdien hentes fra NAIS-console → Secrets → slack 
  - ny repository **secret** `TEAM_UFORE_PRIVATE_KEY`. Verdien hentes fra NAIS-console → Secrets → github-app
- for repoets side på GitHub → Settings → General → Pull request
  - aktiver "Allow rebase merging" 
  - aktiver "Allow auto-merge"
  - aktiver "Automatically delete head branches"
- for repoets side på GitHub → Settings → Rulesets → New ruleset → Import a ruleset  
  - velg fila [rulesets/beskytt_main.json](/rulesets/beskytt_main.json)
  - trykk 'Create'
- legg til navnet på ditt repo til [Team Uføres](https://github.com/apps/team-ufore/installations/98878472) "repository access" på GitHub
- i `main.yaml` er det to rader som forhindrer deployment til `dev-gcp` og `prod-gcp`. Fjern disse radene når du er klar for deployment
- slett dette avsnittet fra README.md og oppdater med relevant beskrivelse av ditt nye repo

### Bygging og denslags
For å bygge artifaktene:

```sh
./gradlew build
```
---

## Henvendelser

Spørsmål knyttet til koden eller repositoryet kan stilles som issues her på GitHub

### For Nav-ansatte

Interne henvendelser kan sendes via Slack i kanalen #team-uføre.

# TODO for å få denne malen til å bli fullt brukbar
- [x] Auto-merge Dependabot PRs
- [x] Dependabot - automerge må forutsette grønt bygg
- [x] Pin actions til SHA
- [x] Følg anbefalt oppsett for NAIS: https://docs.nais.io/build/how-to/deploy-pipeline/
- [ ] Skal vi bygge artifaktet som en fet JAR, eller finnes det bedre måter?
- [x] Deployment til dev-gcp og prod-gcp
- [x] Legg til en server for å unngå CrashLoopBackOff ved deploy
- [x] Fiks alerts
- [ ] Fjern dette avsnittet
