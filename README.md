# Mal for Team Uføres Kotlin-repositories

Beskrivelse av hva appen/tjenesten/tingen som lages i dette repositoryet gjør.

## Komme i gang
### Forutsetninger
- [JDK](https://jdk.java.net/)
- [Kotlin](https://kotlinlang.org/)
- [Gradle](https://gradle.org/) brukes som byggeverktøy og er inkludert i oppsettet

For hvilke versjoner som brukes, [se versjonsfilen](/gradle/libs.versions.toml)

### Følgende steder må endres for å få repoet ditt til å fungere
- søk etter `ufore-XXX` og erstatt med navnet på ditt repo 
- på repoets side på GitHub → Settings → Secrets and variables → Actions
  - ny variabel `TEAM_UFORE_CLIENT_ID`
  - ny repository secret `TEAM_UFORE_PRIVATE_KEY`. Denne hentes fra NAIS-console → Secrets
- legg til navnet på ditt repo til [Team Uføres](https://github.com/apps/team-ufore/installations/98878472) "repository access" på GitHub 

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
