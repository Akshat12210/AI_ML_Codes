#Magic Square 
"""
given a n*n matrix
the problem is to fill the matrix from numbers ranging from 1-n*n
under the condition that 
    1. no number should repeat itself
    2. the sum of rows, columns and diagonals must be equals to (n*(n*n+1))/2
"""
import numpy as np
def checkUpRight(row,col,arr):
  row=row-1
  col=col+1
  if(row<0):
    row=len(arr)-1
  if(col>len(arr)-1):
    col=0
  if(arr[row][col]!=0):
    return False
  else:
    return True

size=int(input("Enter size of magic square   "))
row=int(input("Enter index of starting position (row)  "))
col=int(input("Enter index of starting position (col)  "))
ans=True;
if(row<0  or col<0 or row>=size or col>=size):
  print("Invalid parameters")
  ans=False;
print("Sum of each row,diagonal,column --> ", size*(int((size**2+1)/2)))
if(ans):
  arr=np.zeros((size,size))
  arr[row][col]=1

  for i in range(2,size*size+1):
    if(checkUpRight(row,col,arr)):
      row=row-1
      col=col+1
      if(row<0):
        row=size-1
      if(col>size-1):
        col=0
    else:
      row=row+1
      if(row>size-1):
        row=0
    arr[row][col]=i
  print(arr)