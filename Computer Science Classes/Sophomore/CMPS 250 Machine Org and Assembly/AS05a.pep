BR newinp 


;Anthony Lucchese
;CMPS 250 Prof. Jackowitz
;Collaborated with: Prisco Pocius
;Deficiencies: None

first:   .BLOCK  2           ;first input
second:  .BLOCK  2           ;second input
product:   .BLOCK  2           ;the product

times:   .ASCII  " * \x00"
eq:      .ASCII  " yields \x00"
nl:      .ASCII  "\n\x00"
end:     .ASCII  "Done!!!\x00" 

main:    NOP0

newinp:  DECI    first,d     ;input the first variable
         DECI    second,d    ;input the second variable
         LDWA    0,i         ;reset the product
         STWA    product,d

zero:    LDWA    0,i
         CPWA    first,d     ;this method is just to check if there is a double zero
         BRNE    init
         CPWA    second,d    ;"
         BREQ    quit


init:    LDWA    first,d     ;loads the first number
         STWA    -2,s        ;stores it in the -2 location in the stack
         LDWA    second,d    ;loads the second number
         STWA    -4,s        ;stores it in the -4 location (2 bytes past the first location)
         SUBSP   4,i         ;subtracts stack pointer by 4, to the second location
         CALL    multiply    ;starts the iteration, and calls multiplication
         ADDSP   4,i         ;adds the stack pointer back, returning to the original start location
         STWA    product,d   ;stores the product, and prints the product
         

print:   DECO    first,d     ;"
         STRO    times,d     ;"
         DECO    second,d    ;"
         STRO    eq,d        ;prints out 'x * y yields z'
         DECO    product,d   ;"
         STRO    nl,d        ;"
         BR      newinp      ;breaks to new input, and there it checks if you need to quit the program 

         
quit:    STRO    end,d       ;of course, this just ends the program
         STOP    



operand1:.EQUATE 2           ;stack variable that is in place of 'first'
operand2:.EQUATE 4           ;stack variable that is in place of 'second'



multiply:LDWA    0,i         ;loads zero into the A register
         LDWX    operand2,s  ;loads second into the X register
recur:   CPWX    0,i         ;sees if the second variable is equal to zero (meaning the iteration should end)
         BREQ    sumdif      ;branches to return when it equals 0 and ends the recursion
         SUBX    1,i         ;subtracts one from the x register, because when this equals 0, it ends the program
         ADDA    operand1,s  ;adds the first operand to the second, adding one iteration of multiplication
         BR      recur       ;branches back to the beginning of the subprogram to recurse it



sumdif:  RET
         .END




