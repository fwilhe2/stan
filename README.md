# Stan - The *St*atement *An*alyzer

| Linux | Windows |
| :---- | :------ |
[ ![Linux build status][1]][2] | [![Windows build status][3]][4] |

[1]: https://travis-ci.org/sschuberth/Stan.svg?branch=master
[2]: https://travis-ci.org/sschuberth/Stan
[3]: https://ci.appveyor.com/api/projects/status/xeyju8npt336ley5/branch/master?svg=true
[4]: https://ci.appveyor.com/project/sschuberth/Stan/branch/master

## What's this?

Stan is both a library and command line tool to convert and analyze bank account statements. It works completely offline by parsing the statement files you specify and does not require any online or [HBCI](http://www.hbci-zka.de/spec/spezifikation.htm) connection.

## What statement files are supported?

- [Postbank PDF](https://www.postbank.de/privatkunden/docs/Kontoauszug_A4_Privatkunden.pdf)

  The Postbank has changed the format for PDF account statements multiple times. The supported formats are the ones introduced in July 2014 and in June 2017, respectively.

## What file formats can be exported to?

- [CSV](https://en.wikipedia.org/wiki/Comma-separated_values)

  CSV files offer a simple generic way to further process the statement data, e.g. in online tools like [Priotecs MoneyControl](https://primoco.me/).

- [Excel](https://en.wikipedia.org/wiki/Microsoft_Excel)

  Excel 2007 XLSX files are supported.

- [JSON](https://www.json.org/)

  JSON files offer a powerful generic way to further process the statement data.

- [MT940](https://de.wikipedia.org/wiki/MT940) (support is experimental)

  MT940 files can be imported to many (professional) finance applications, e.g. [AckiSoft Finanzmanager](https://www.ackisoft.de/).

- [OFX version 1](http://www.ofx.net/downloads.html)

  OXF files can be imported into finance applications like [GnuCash](https://www.gnucash.org/), [HomeBank](http://homebank.free.fr/en/index.php) or [jGnash](https://ccavanaugh.github.io/jgnash/).

- [QIF](https://en.wikipedia.org/wiki/Quicken_Interchange_Format)

  QIF files can be imported into finance applications like [GnuCash](https://www.gnucash.org/), [HomeBank](http://homebank.free.fr/en/index.php), [jGnash](https://ccavanaugh.github.io/jgnash/) or [Money Manager Ex](https://www.moneymanagerex.org/).

## How to run the command line tool?

As there are no binary releases yet, the easiest way to run Stan currently is by cloning the source code repository and
leveraging Gradle's [run task](https://docs.gradle.org/current/userguide/application_plugin.html#sec:application_tasks):

    $ ./gradlew :cli:run --args="--help"

This will both build (if required) and run Stan. Then follow the usage instructions and replace `--help` in the above
run with the desired options.

Alternatively, you can first create / install OS-specific run scripts via

    $ ./gradlew installDist

and then run Stan by executing a script like

    $ ./cli/build/install/stan/bin/stan --help
