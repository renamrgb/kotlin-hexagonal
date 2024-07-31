package com.renamrgb.hexagonal.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures.layeredArchitecture

@AnalyzeClasses(packages = ["com.renamrgb.hexagonal"])
class LayeredArchitectureTest {

    @ArchTest
    val layeredArchitectureTest = layeredArchitecture()
        .consideringAllDependencies()
        .layer("Adaptersin").definedBy("..adapters.in..")
        .layer("AdaptersOut").definedBy("..adapters.out..")
        .layer("UseCase").definedBy("..application.core.usecase..")
        .layer("PortsIn").definedBy("..application.ports.in..")
        .layer("PortsOut").definedBy("..application.ports.out..")
        .layer("Config").definedBy("..config..")
        .whereLayer("Adaptersin").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("PortsIn").mayOnlyBeAccessedByLayers("UseCase", "Adaptersin")
        .whereLayer("PortsOut").mayOnlyBeAccessedByLayers("UseCase", "AdaptersOut")
        .whereLayer("Config").mayNotBeAccessedByAnyLayer()!!
}