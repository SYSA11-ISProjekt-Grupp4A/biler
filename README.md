# Biler - A SYSA project.

## About
An application for a car rental company. Handles Products, Persons, Bookings etc.

## Libraries
* Apache commons-io FileUtils.
* JUnit (commons-io uses it)

## Usage example

### Get source - (in e.g. bash)
* git clone https://github.com/SYSA11-ISProjekt-Grupp4A/biler.git
* cd biler
* git submodule update --init

### IntelliJ

#### Import the project.
* Just import it and pray to God of Luck. (Uncheck all extraneous
  sources/modules/libs, only commons-io/src/main/java and junit/src/main/java
  should be added as source directories).

#### (or) Recreate the project
* Create new project and point it to /biler
* Add libs/commons-io/src/main/java to source paths.
* Add libs/junit/src/main/java to source paths.
* Add libs/junit/lib/hamcrest-core-1.3.jar (or similar) as a library.

### Eclipse

#### Import biler.
New project, call it Biler (or whatever), specify /biler directory as the directory.

#### Import commons-io
New project, call it commons-io (exactly), specify /biler/libs/commons-io directory as the directory.

### Run it
BAM!

### Give feedback.
Because we'd appreciate it.
