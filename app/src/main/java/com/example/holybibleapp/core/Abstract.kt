package com.example.holybibleapp.core

class Abstract {

    abstract class Object<T, M : Mapper> {

        abstract fun map(mapper: M): T
    }

    // FIXME: 05.04.2022 rename
    interface Mapable<T, M : Mapper> {
        abstract fun map(mapper: M): T
    }

    interface Mapper {
        class Empty : Mapper
    }
}