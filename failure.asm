l r4 d0 Temperature
s db Setting r4
jal 49
push r4
push 293.15
jal 46
jal 20
jal 56
pop r5
s d1 Setting r5
jal 49
push r4
push 303.15
jal 46
jal 33
jal 56
pop r5
s d2 Setting r5
yield
j 0
push ra
push r0
push r1
jal 64
jal 78
beq r12 0 30
pop r14
push 1
j r14
j 33
pop r14
push 0
j r14
push ra
push r0
push r1
jal 68
jal 78
beq r12 0 43
pop r14
push 1
j r14
j 46
pop r14
push 0
j r14
pop r1
pop r0
j ra
push r0
push r1
push r2
push r3
push r4
push r5
j ra
pop r12
pop r5
pop r4
pop r3
pop r2
pop r1
pop r0
j 76
pop r13
pop r12
blt r12 r13 72
j 74
pop r13
pop r12
bgt r12 r13 72
j 74
push 1
j ra
push 0
j ra
push r12
j ra
pop r12
round r12 r12
j 76
