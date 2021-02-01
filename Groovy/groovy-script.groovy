
​def nombre = "William"
println nombre
def saluda = "Hola $nombre"
println saluda

def numero1 = 4
def numero4 = 3
println "Suma: $numero1 + $numero4"
println "Suma: ${numero1 + numero4}"​

def metodo(){
    println "Primer metodo"
    return "Método 1"
}

def nombreMetodo = metodo()
println nombreMetodo


def metodoII(param){
    return "Param: $param"
}

def metodoEjecutado= metodoII "Param A"
println metodoEjecutado


def lista = ["elem1", "el2", "ele3", "e4"]
lista.add("eleme5")
lista.each {
    el -> println "Elemento: $el"
}

lista.each {
    println "Elemento con it: $it"
}

lista.eachWithIndex {
    el, index -> println "Elemento: $el está en posición: $index"
}

println lista.findAll( {el -> el == "el2"})