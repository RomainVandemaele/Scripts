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