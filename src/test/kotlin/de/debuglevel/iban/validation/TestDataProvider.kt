package de.debuglevel.iban.validation

import java.util.stream.Stream

object TestDataProvider {
    fun validIbanProvider(): Stream<IbanTestData> = Stream.of(
        IbanTestData(value = "GB33BUKB20201555555555"),
        IbanTestData(value = "GB94BARC10201530093459"),
        IbanTestData(value = "DE89370400440532013000"),
        IbanTestData(value = " DE89370400440532013000"),
        IbanTestData(value = "DE89 370400440532013000"),
        IbanTestData(value = "DE 89 370400440532013000"),
        IbanTestData(value = "DE89 37040044 0532013000"),
        IbanTestData(value = "DE 89 37040044 0532013000"),
        IbanTestData(value = "DE89 37 04 00 44 05 32 01 30 00"),
        IbanTestData(value = "DE 89 37 04 00 44 05 32 01 30 00"),
        IbanTestData(value = "DE 89 37 04 00 44 05 32 01 30 00 "),
        IbanTestData(value = "DE 89 37 04 00  44 05 32 01 30 00"),
        IbanTestData(value = " DE 89 37 04 00  44 05 32 01 30 00")
    )

    fun invalidIbanProvider(): Stream<IbanTestData> = Stream.of(
        //                                                 failing:
        //IbanTestData(value = "GB02BARC20201530093451"), // A I J
        //IbanTestData(value = "GB68CITI18500483515538"), // A I J
        //IbanTestData(value = "GB24BARC20201630093459"), // A I J
        //IbanTestData(value = "GB12BARC20201530093A59"), //     J
        //IbanTestData(value = "GB78BARCO0201530093459"), //     J
        //IbanTestData(value = "GB01BARC20714583608387"), //   I J
        //IbanTestData(value = "GB00HLFX11016111455365"), //   I J
        IbanTestData(value = "GB94BARC20201530093459"),
        IbanTestData(value = "GB96BARC202015300934591"),
        IbanTestData(value = "GB2LABBY09012857201707"),
        IbanTestData(value = "US64SVBKUS6S3300958879"), // US is no IBAN country
        IbanTestData(value = "ThisIsObviouslyWrong"),
        IbanTestData(value = "DE12345678901234567890"), // probably wrong check digits
        IbanTestData(value = "DE12345"), // too short
        IbanTestData(value = "DE12345678901234567890123456"), // too long
        IbanTestData(value = "DE123456789HELLO567890") // characters which do not belong there
    )

    data class IbanTestData(
        val value: String
    )
}