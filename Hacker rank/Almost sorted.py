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
    


if __name__ == '__main__':
    #n = int(input())

    #arr = list(map(int, input().rstrip().split()))
    arr = [1,2,3,4,7,5]
    swap(arr)
