package br.com.matheuscosantos

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.matheuscosantos")
		.start()
}

