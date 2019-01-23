#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sat Jan 12 18:01:21 2019

@author: ritsuki
"""

import random
import csv

data_list=[]

with open("/home/ritsuki/Sekigae/simulation.csv",encoding="utf-8") as csvfile:
    csv_data=csv.reader(csvfile)
    for row in csv_data:
        data_list.append(row)


x=int(input("How many lines?\n"))
y=int(input("How many rows?\n"))

while(True):
    stu=int(input("How many students?\n"))
    if stu>x*y: print("error! A number of students exceeds in a number of seats\n")
    else: break


no=x*y-stu

seki=[[0 for gyo in range(0,x+5)] for retu in range(0,y+5)]


i=0
if no>0:
    print("Point out places which has no seats\n")
    while(True):
        print("The place with no seats(%s/%s)\n" % (i, no))
        a=int(input("What line?\n"))
        b=int(input("What row?\n"))
        if seki[a][b]==-1: 
            print("error! The seat has been inputted\n")
            i=i-1
        else: 
            seki[a][b]=-1
            i=i+1
        if i==no: break

flag=[0 for j in range(0,stu+2)]

while(True):
    eye=int(input("How many students who needs to be taken care of because of their eyes\n"))
    if eye>stu: print("error! A number of the students exceeds in a number of all students\n")
    else:  break


flag2=[0 for j in range(0,stu+2)]
i=0
while(True):
    num=int(input("What number of the student who needs cares?\n"))
    if flag2[num]==0:
        flag2[num]=1
        while(True):
            a=random.randint(1,eye/y+1)
            b=random.randint(1,y)
            if seki[a][b]==0:
                seki[a][b]=num
                flag[num]=1
                break
        i=i+1
    else:
        print("error! The number has already been inputted\n")
        i=i-1
    if i==eye:
        break

for gyo in range(1,x+1):
    for retu in range(1,y+1):
        if seki[gyo][retu]==0:
            num=1
            while(True):
                num=random.randint(1,stu)
                if flag[num]==0:
                    flag[num]=1
                    break
            seki[gyo][retu]=num
        if seki[gyo][retu]>0:
            print('{:>3}'.format(seki[gyo][retu]))
            print("%s",data_list[seki[gyo][retu]],end="")
        else:
            print(" X ",end="")
    print("\n")

