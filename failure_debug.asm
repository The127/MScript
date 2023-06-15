destGotoLabel: __push_registers
destGotoLabel: __pop_params_2
Runtime: enabling 'function call'.
destGotoLabel: __pop_registers
destGotoLabel: __push_registers
destGotoLabel: __pop_params_2
destGotoLabel: __pop_registers
destGotoLabel: __loop__XTljFHuEzokLxcIuXfOwVbEDYRSMbpax
destGotoLabel: __less
Runtime: enabling 'less'-comparison.
destGotoLabel: __condition
Runtime: enabling condition evaluation.
destGotoLabel: __conditionalIf__EHkZAawWaJyOEpLKitfeOmbHhnINgnQA
destGotoLabel: __conditionalEnd__YKGrFqFcXBNXpBWiZhnzhazfIsEZGsAv
destGotoLabel: __greater
Runtime: enabling 'isGreater'-comparison.
destGotoLabel: __condition
destGotoLabel: __conditionalIf__cgDzISrSfpkeJkxUYwAXpIubmsoyrVob
destGotoLabel: __conditionalEnd__PdsZUQTvLEpuzSXWKubkViIZkrhuwxBh
Runtime: enabling 'return'.
destGotoLabel: __ret
Runtime: enabling 'return true'.
destGotoLabel: __jTrue
destGotoLabel: __jFalse
destGotoLabel: __jTrue
destGotoLabel: __jFalse
destGotoLabel: __ret
BEGIN DEBUG Runtime-Output
isLessUsed: true
isGreaterUsed: true
isFunctionCalled: true
isConditionEvaluated: true
isRetUsed: true
isRetTrueFalseUsed: true
END DEBUG Runtime-Output

BEGIN DEBUG Runtime-Code
j ra
{source::goto::__push_registers}
j ra
{source::goto::__pop_registers}
pop r12
j {dest::goto::__ret}
{source::goto::__less}
pop r13
pop r12
blt r12 r13 {dest::goto::__jTrue}
j {dest::goto::__jFalse}
{source::goto::__greater}
pop r13
pop r12
bgt r12 r13 {dest::goto::__jTrue}
j {dest::goto::__jFalse}
{source::goto::__jTrue}
push 1
j ra
{source::goto::__jFalse}
push 0
j ra
{source::goto::__ret}
push r12
j ra
{source::goto::__condition}
pop r12
round r12 r12

END DEBUG Runtime-Code

Generated code:


####### main
push ra
l r4 d0 Temperature
s db Setting r4
jal 50
push r4
push 293.15
jal 47
jal 21
jal 57
pop r5
s d1 Setting r5
jal 50
push r4
push 303.15
jal 47
jal 34
jal 57
pop r5
s d2 Setting r5
yield
j 1
######## end of main


push ra
push r0
push r1
jal 65
jal 79
beq r12 0 31
pop r14
push 1
j r14
j 34
pop r14
push 0
j r14


push ra
push r0
push r1
jal 69
jal 79
beq r12 0 44
pop r14
push 1
j r14
j 47
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
j 77
pop r13
pop r12
blt r12 r13 73
j 75
pop r13
pop r12
bgt r12 r13 73
j 75
push 1
j ra
push 0
j ra
push r12
j ra
pop r12
round r12 r12
