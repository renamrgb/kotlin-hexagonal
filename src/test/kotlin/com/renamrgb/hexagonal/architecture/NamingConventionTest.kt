package com.renamrgb.hexagonal.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

@AnalyzeClasses(packages = ["com.renamrgb.hexagonal"])
class NamingConventionTest {

    @ArchTest
    val `consumer reside only consumer package` = classes()
        .that()
        .haveNameMatching(".*Consumer")
        .should()
        .resideInAPackage("..adapters.in.listiners")
        .`as`("As classes de consumidor devem estar dentrdo do pacote adapters.in")

    @ArchTest
    val `response reside only response package` = classes()
        .that()
        .haveNameMatching(".*Response")
        .should()
        .resideInAnyPackage("..adapters.in.controller.response", "..adapters.out.client.response")
        .`as`("Classes de response devem estar nos pacotes de controller ou client")
}