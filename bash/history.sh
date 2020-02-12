#!/bin/bash

echo "Hello $@ $# $USER $SECONDS"

#cp $1 $2
# Let's verify the copy worked
#echo Details for $2
#ls -lh $2

# name="Romain Vandemaele"
# echo $name

# file=/etc/bluetooth

# countFile=$( ls $file | wc -l )
# echo "There is $countFile files in $file"

# export file #make var file available in script called within

word=$(head -$RANDOM  /usr/share/dict/words | tail -1)

echo $word


#ex1 print random word : 
n=$RANDOM
word=$(egrep ^.{$1}$  /usr/share/dict/words | head -$n | tail -1)
echo $word

#ex2 do a copy and add date to name  2020-02-10_file1.txt

filename=$(date +%F)_$1.txt
filename=$(basename -s .txt $1)_$(date +%F).txt

basename -s .txt -a $@ | xargs -n1 -i cp {}.txt {}_$(date +%F).txt
#cp $1 $filename

#INPUT

echo Hello, who am I talking to?
#read -p 'Username: ' uservar
#read -sp 'Password: ' passvar

#read car1 car2 car3 #one input divided in three variables ""if missing rest in last variable
echo It\'s nice to meet you $uservar


echo Here is a summary of the files :
echo ====================================
echo
cat /dev/stdin | awk '{print $9 " owned by " $3}'

#Arithmetic
let a=5+4
echo $a # 9
let "a = 5 + 4"
echo $a # 9
let a++
echo $a # 10
let "a = 4 / 5"
echo $a # 20
let "a = $1 + 30"
echo

expr 5 \* 4
a=$( expr $a - 3 )
echo $a # 7
echo


a=$((3+5))
echo $a # 8
b=$(( a + 3 ))
echo $b # 11
(( b += 3 ))
echo $b # 16
echo


a='Hello World'
echo ${#a} # 11
b=4953
echo ${#b} # 4

echo $(($RANDOM % ($2 - $1) + $1 ))

#CONDITION

# if [ $# -lt 1 ]
# then
#     echo "You need to enter one argument"
# elif [ $1 -gt 100 ] #result in $?
# then
#     echo "You entered a big number"
#     if (( $1 % 2 == 0 ))
#     then
#         echo And is also an even number.
# fi
#     pwd
# fi


# if [ -r $1 ] && [ -s $1 ]
# then
#     echo This file is useful
# fi


case $space_free in
    [1-5]*)
        echo Plenty of disk space available
    ;;
    [6-7]*)
        echo There could be a problem in the near future
    ;;
    8*)
        echo Maybe we should look at clearing out old files
    ;;
    9*)
        echo We could have a serious problem on our hands soon
    ;;
    *)
        echo Something is not quite right here
    ;;
esac

#ex1 : print biggest arg
if [ $# -lt 2 ]
then
    echo "You need to enter two integers argument"
else
    if [ $1 -ge $2 ]
    then
        echo "$1 is the biggest arg"
    else
        echo "$2 is the biggest arg"
    fi
fi

if [ -f $1 ] 
then
    if [ -x $1 ]
    then
        echo "This file can be executed"
    else
        echo "This file cannot be executed"
    fi
else
    echo "The path is not a file or does not exist"
fi


#LOOP
counter=1
while [ $counter -le 10 ]
do
    echo $counter
    ((counter++))
done

for value in {1..10}
do
    if ((value%2==0))
    then
        echo $value is even
    else
        echo $value is odd 
    fi
done

for file in $(ls)
do
    echo $file
done
#ex2
for file in $1/*
do
    if [ -d "$file" ] #print number of files inside
    then
        echo $file is a directory filled with $(ls "$file" | wc -l) files
    elif [ -f "$file" ]
    then
        echo $file is a file which take $(ls -lh "$file" | awk '{print $5}') of memory
    fi
done


names='Kyle Cartman Stan Quit'
PS3='Select character: '
select name in $names
do
    if [ $name == 'Quit' ]
    then
        break
    fi
    echo Hello $name
done

#FUNCTIONS

function print_something {
    echo Hello $1
    return 0 #return status 0=OK
}

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
