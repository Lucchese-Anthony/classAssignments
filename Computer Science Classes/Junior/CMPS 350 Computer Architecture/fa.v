module fa(
    output S, Co,
    input A, B, Ci 
);
    wire a1, a2, a3;
    
    xor u1(a1, A, B);
    and u2(a2, A, B);
    and u3(a3, a1, Ci);
    or  u4(Co, a2, a3);
    xor u5(S, a1, ci);

endmodule

module tb();

    reg a,b,ci;
    wire s, co;

    fa  struct_adder (
    .A(a),
    .B(b),
    .Ci(ci),
    .Co(co),
    .S(s)
    );

    initial begin

    $monitor("Sum: %d | Cout: %d\n", s, co);
    
    a=0;b=0;ci=0;#10;
    a=0;b=0;ci=1;#10;
    a=0;b=1;ci=0;#10;
    a=0;b=1;ci=1;#10;
    a=1;b=0;ci=0;#10;
    a=1;b=0;ci=1;#10;
    a=1;b=1;ci=0;#10;
    a=1;b=1;ci=1;#10;

   end

endmodule

