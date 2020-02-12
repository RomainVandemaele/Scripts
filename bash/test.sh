#!/bin/bash


var_change () {
    local var1='local 1'
    echo Inside function: var1 is $var1 : var2 is $var2
    var1='changed again'
    var2='2 changed again'
    local a='ok' #without local a can be used outside the function after it is first called
}

ls () { #overridding ls : ls this function comand ls : classic ls
    command ls -lh #function used as wrapper to avoid repeating -ls in every use of ls
}

var1='global 1'
var2='global 2'
echo Before function call: var1 is $var1 : var2 is $var2
var_change
echo After function call: var1 is $var1 : var2 is $var2
echo $a