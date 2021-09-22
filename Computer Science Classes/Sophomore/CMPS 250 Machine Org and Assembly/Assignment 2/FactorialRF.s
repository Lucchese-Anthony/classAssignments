	.file	"FactorialRF.c"
	.text
	.globl	factorial
	.type	factorial, @function
factorial:
.LFB0:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$24, %esp
	subl	$12, %esp
	pushl	$64
	call	DumpS
	addl	$16, %esp
	cmpl	$1, 8(%ebp)
	jg	.L2
	movl	$1, -12(%ebp)
	jmp	.L3
.L2:
	movl	8(%ebp), %eax
	subl	$1, %eax
	subl	$12, %esp
	pushl	%eax
	call	factorial
	addl	$16, %esp
	movl	%eax, %edx
	movl	8(%ebp), %eax
	imull	%edx, %eax
	movl	%eax, -12(%ebp)
.L3:
	subl	$12, %esp
	pushl	$64
	call	DumpS
	addl	$16, %esp
	movl	-12(%ebp), %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE0:
	.size	factorial, .-factorial
	.ident	"GCC: (GNU) 8.3.1 20191121 (Red Hat 8.3.1-5.0.3)"
	.section	.note.GNU-stack,"",@progbits
