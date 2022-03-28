package com.sevenpeak.main.common

interface Mapper<F, T> {
    fun map(from: F): T
}