#!/bin/python3

import math
import os
import random
import re
import sys

"""
Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time.

    1.Swap two elements.
    2.Reverse one sub-segment.
"""

# Complete the almostSorted function below.
def almostSorted(arr):
    #first check for swap
    i = 0
    sorted = True
    swapable = True
    end = False
    swapI1,swapI2 = -1,-1
    max = 0
    while i < len(arr) - 1 and swapable and not end :
        if sorted :
            if(arr[i] > arr[i+1] ) :
                sorted = False
                swapI1 = i
                if(i > 0) : max = arr[i-1]
        else :
            if(arr[i] < max) : swapable = False
            elif(arr[i] > arr[i+1]) :
                if(arr[i+1] < max or arr[swapI1] < arr[i]) : 
                    swapable = False
                else :  
                    swapI2 = i + 1
                    max = arr[swapI1]
                    end = True
        i+=1    
    if(sorted) :
        print("yes")
    elif(swapable) : #check if
        while i < len(arr)-1 :
            if(arr[i] > arr[i+1] or arr[i+1] < max) :
                swapable = False
            i+=1
        if(swapable) :
            print("yes")
            print("swap ",swapI1+1,swapI2+1)
        else :
            print("no")
    else :
            print("no")


def swap(arr) :
    i=0
    n = len(arr) 
    max = 0
    swapI1,swapI2 = -1,-1
    sorted = False

    while(i<n-1 and arr[i] <= arr[i+1]) :
        i+=1
    max = arr[i-1]
    swapI1 = i              
    #print(swapI1)
    if(i==n) : 
        sorted=True

    i+=1
    while(i<n-1 and arr[i] <=arr[i+1] ) :
        i+=1
        pass
    
#done
def biggerIsGreater(w):
    i = len(w) - 2
    #stop = False
    #min = w[len(w)-1] 

    while i>=0 and w[i] >= w[i+1] :
        i-=1

    #print(i,end=" ")
    if(i==-1)  :
        return "no answer"
    else :
        swap = i+1
        for j in range(i+1,len(w)) :
            if(w[j] > w[i] ) : #and w[j] < w[swap]) :
                swap = j
        w = w[:i] + w[swap] + w[i+1:swap] + w[i] + w[swap+1:]
        w2 = w[i+1:]
        w = w[:i+1]
        for k in range(len(w2)-1,-1,-1) :
            w += w2[k]
        return w


#TODO : make it faster
def gridSearch(G, P):
    found = False
    i = 0
    j = 0
    index = -1
    c = len(P[0])
    while i < len(G) and not found :
        index = G[i].find(P[0])
        while(index!=-1 ) :
            found = True
            oldI = i
            j+=1
            i+=1
            while found and i< len(G) and j < len(P) and G[i].find(P[j])==index :
                """
                k = index
                while(k < index + c and G[i][k]==P[j][k-index] ) :
                    k+=1
                if(k < index + c) : found = False
                """
                i+=1
                j+=1
            found = found and j==len(P)
            if(found) :
                index = -1
            else :
                j=0
                i = oldI
                index = G[i][index+1:].find(P[0])        
        i+=1
    if found :
        return "YES"
    else : 
        return "NO"
    
def absolutePermutation(n, k):
    l = [i for i in range(1,n+1)]
    possible = True

    if(k==0) :
        res=""
        for i in range(len(l)) :
            res+=str(l[i]) + " "
        return l
    elif(n%(2*k)!=0) :
        return [-1]

    i=0
    while possible and i < n :
        #print(i)
        for j in range(i,i+k) :
            #print("switch ",l[j],l[j+k])
            l[j],l[j+k] = l[j+k],l[j]
        i+=2*k
        
        

    if not possible : 
        return [-1]
    else :
        res=""
        for i in range(len(l)) :
            res+=str(l[i]) + " "
        return l


if __name__ == '__main__':
    
    res = absolutePermutation(int(sys.argv[1]),int(sys.argv[2]))
    if(len(res)==1) :
        print(res)
