# **JavaMath**

This is program for some math function created by me. They are not exactly efficient, they are just for education purposses. No other information is not now provided.

<!--
## **Structure of files**

- "***src/App.java***" - function are called from this file. There are some examples, which you can un-comment to acces. All math functions are located in "*src/lib/java/math*". 
- "***src/lib/java/math/functions/***" - place where all my math function are located.
- "***src/lib/java/math/plotter/***" - place where all my plots are located.
- "***src/lib/java/constants/***" - place where some constants, declared by my self or created by functions, are located.
- "***src/lib/math/complex/***" - place where all files and folder of complex mathematics are located.
- "***img/***" - place where all additional images are located.
# **Functions which are based on real numbers**
## **What constants there currently are?**
- **Stieljes constants** - Stieltjes constants are taken from *https://gist.github.com/cab1729/1318030*. There are only from 0 to 78. You can read more about them on wikipedia: *https://en.wikipedia.org/wiki/Stieltjes_constants*.
## **What function are now working?**

- **Sign function** ("*src/lib/java/math/function/sign_function.java*") - Simple function that returns *-1* is number *x* is lower than *0*, returns *0* if *x* is equal to *0* and returns *1* if *x* is larger than *0*. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Sign_function*.
- **Prime omega functions** ("*src/lib/java/math/functions/prime_omega_function.java*") - They are counting number of prime factors of natural number n. Lowercase omega function *ω(n)* returns amount of unigue factors and uppercase omge function *Ω(n)* returns number of all factors. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Prime_omega_function*.
- **Liouville function** ("*src/lib/java/math/functions/liouville_function.java*") - Returns *-1* or *+1* depending on output of *Ω(n)*. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Liouville_function*.
- **Kronecker function** ("*src/lib/java/math/functions/kronecker_delta.java*") - Returns *0* or *+1* depending if number *i* is or isn't equal to number *j*. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Kronecker_delta*.
- **Möbius function** ("*src/lib/java/math/functions/mobius_function.java*") - Return *0*, *-1* or *+1* depending if number is prime, number has squared prime factor or even number of prime factors. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Möbius_function*.
- **Gamma function** ("*src/lib/java/math/functions/gamma_function.java*") - Extension of the factorial function. Output of Gamma function *Γ(z)* is only Lanczos approximation. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Gamma_function*; *https://en.wikipedia.org/wiki/Lanczos_approximation*.
- **Riemann zeta function** ("*src/lib/java/math/functions/riemann_zeta_function*") - Algoritm for well-known Euler-Riemann zeta function. Input works only for real numbers higher than *1*. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Riemann_zeta_function*.
- **Bernoulli numbers** ("*src/lib/java/math/function/bernoulli_number.java*") - Algoritm for creating bernoulli numbers. Currently works only with integers higher or eqaual to *1*. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Bernoulli_number#Generating_function*.
- **Divisor function** ("*src/lib/java/math/function/diviser_function.java*") - Function that counts number of divisors of an integer including *1* and itself. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Divisor_function#Formulas_at_prime_powers*.
- **Binomial coefficient** ("*src/lib/java/math/functions/binomial_coefficient.java*") - Used factorial formula for computing them, not working for bigger numbers thanks to *double* variables and their limits. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Binomial_coefficient*.

## **What function you can plot?**
- **Möbius function** ("*src/lib/java/math/plotter/function_plotter/mobius_plotter.java*") - You can plot values of Möbius function *μ(n)* from *1* to *50*. With some editing you can add more values, but it will become really messy. <br />
![plot](./img/mobius_function_plot.png) ![plot](./img/gamma_function_plot.png)
- **Gamma function** ("*src/lib/java/math/plotter/function_plotter/gamma_plotter.java*") - You can plot values of Gamma function *Γ(z)* from *-5* to *5*. With some editing you can expand to more values, but it will again become really messy. <br />
- **Riemann zeta function** ("*src/lib/java/math/plotter/function_plotter/zeta_plotter.java*") - You can plot values of Riemann zeta function from *-1* to *5*. You can ho higher than *5* but lower that *-1* it wont work. Also, my algorithm is very slow, so it outputs some inaccurate answers to become more faster. <br />
<!-- ![plot](./img/zeta_function_plot.png) -->
- **Sawtooth wave** - You can plot approx of sawtooth wave from *-5* to *5*. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Sawtooth_wave*. <br />
![plot](.img/../img/sawtooth_wave_plot.png)
# **Complex numbers and functions**
## **What complex operations it can perform?**

- Nearly all my knowledge about complex numbers and their operations is taken from wikipedia: *https://en.wikipedia.org/wiki/Complex_number*.
- There is also something named BigComplexNumbers. This is just complex numbers but with more precision using BigDecimal. I need it for some functions like *stieltjes constants* or *hurwitz zeta function*. It's needed because *java double* has small limit for those functions.
- My algorithms for complex numbers currently supports:
  - **Addition & Subtraction**
  - **Multiplicaton & Division**
  - **Square & Square root**
  - **Exponential function**
  - **Natural logarithm**
  - **Sine & Cosine; Tangent & Cotangent; Secant & Cosecant**
  - **Arctan**
  - **Sinh & Cosh; Tanh & Coth; Sech & Csch**
  - **Exponentiation**
  - **Mod**

## **What complex functions are now working?**

- **Gamma function** ("*src/lib/java/math/complex/functions/complex_gamma_function.java*") - Extension of gamma function to all complex numbers. Again you can read more on wikipedia: *https://en.wikipedia.org/wiki/Gamma_function*. I used the same approximation, just modified for complex numbers, as for gamma function for real numbers: *https://en.wikipedia.org/wiki/Lanczos_approximation*.
- **Riemann zeta function** ("*src/lib/java/math/complex/functions/complex_zeta_function.java*") - Extension of zeta function ti all complex numbers except *1*. This is done thanks to Abel-Plana formula: *https://en.wikipedia.org/wiki/Abel–Plana_formula*, and integral is solved with Composite Simpson's Rule *https://en.wikipedia.org/wiki/Adaptive_quadrature*. You can read more again on wikipedia: *https://en.wikipedia.org/wiki/Riemann_zeta_function*.
- **Beta function** ("*src/lib/java/math/complex/functions/complex_beta_function.java*") - Beta function *B(x, y)* has two input values, but only one output. It is symetric function and you can real more on wikipedia: *You can read about this function on wikipedia: *https://en.wikipedia.org/wiki/Beta_function*.*
- **Eisenstein series** ("*src/lib/java/math/complex/function/fourier_series/eisenstein_series.java*") - Fourier series of Eisenstein series. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Eisenstein_series*.
- **Hurwitz zeta function** ("*src/lib/java/math/complex/functions/complex_hurwitz_zeta_function.java*") - One of zeta functions. It's approximation works for all *s* and for *a* with real part grater than one. It's approximation is not exactly precise. For larger numbers, more than *5* or so, it's precision is about *1/2*, so you get answer *0.5* larger. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Hurwitz_zeta_function*. I used this formula for calculating: *https://functions.wolfram.com/ZetaFunctionsandPolylogarithms/Zeta2/07/01/01/01/0002/*
- **Stieltjes generalized constants** ("*src/lib/math/complex/functions/complex_stieljes_constant.java*") - Generalization of stieljes constants. Its done with approx integral calculation and thanks to wikipedia: *https://en.wikipedia.org/wiki/Stieltjes_constants#Generalized_Stieltjes_constants*. Works only for *n* being an non-negative integer and *a* not being equal to non-positive integers. It's just an approximation.
- **Digamma function** ("*src/lib/math/complex/functions/complex_digamma_constant.java*") - First polygamma function. It is calculated with logarithm approximation. Accuracy can be increased with adding some zeros to "*Infinity*" at computing natural logarithm with *BigDecimals*. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Digamma_function*.
- **Trigamma function** ("*src/lib/math/complex/functions/complex_trigamma_function.java*") - Second polygamma function. It is calculated with series. You can't use non-positive integers as *z* in this function, same as in regular gamma function. You can read more on wikipedia: *https://en.wikipedia.org/wiki/Trigamma_function*.
- **All of trigonomic and hyperbolic functions** - They are located in file for complex numbers and are callable asi them: *"ComplexNumber".sin()* for example. You can read more about each bellow.

## **What complex function can it plot?**

- **Gamma function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_gamma_plotter.java*") - Plotted thanks to domain coloring: *https://en.wikipedia.org/wiki/Domain_coloring*. Color is assigned to angle θ of complex number. Pictures down there are not plotted with this setting, insted there is used product of real and imaginary value as color. Its not exactly precise, but it do it's job. You can choose between printing 22k, 90k or 360k points, this picture is printed with 360k points<br />
![plot](./img/complex/complex_gamma_function_plot.png) ![plot](img/complex/complex_zeta_function_plot.png)
- **Zeta function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_gamma_plotter.java*") - Plotted again thanks to domain coloring with old settings. All properities stay the same as for *Gamma function*. Its not presize with big numbers, its just approximation for smaller numbers. You can choose to plot 5.5k, 20k, 90k, 360k points, which takes something about 10 minuts to print. This picture is prited with 360k points.<br />
- **Beta function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_beta_plotter.java*") - Plotted with domain coloring with old settings. There are two plots. Both are plotted from *-5* to *5* on both axis and. First plot of beta function *B(x,y)*, where *x = a+bi* and *y = b+ai* (*b*, *a* are areal numbers). <br />
![plot](./img/complex/complex_beta_function_plot_1.png) ![plot](img/complex/complex_beta_function_plot_2.png)
- **Eisenstein series** ("*src/lib/java/math/plotter/complex_function_plotter/fourier_series/eisenstein_plotter.java*") - Plotted with domain coloring with old settings. Plot of Eisenstein series with choosable value *k*. You can plot this with 3.7k, 14,4k or 58k points and this plot is made with 58k points. Warning - for more points it takes a huge amount of time. There are plots of G4 and G10. <br />
![plot](./img/complex/g4.png) ![plot](./img/complex/g10.png)
- **Hurwitz zeta function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_hurwitz_plotter.java*") - Can be plotted with new domain coloring (described at gamma function section). It takes a huge amount of time to plot, because it's computation is pretty hard. When I add here an image of this plot, it will be made with rather unprecise values, it will take less amount of time.
- **Digamma function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_digamma_plotter.java*") - Plotted with new domain coloring algorithm. Image below is plotted with 130k points
- **Trigamma function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_trigamma_plotter.java*") - Plotted with domain coloring mencioned above. Image below is plotted with something about 90k points. <br />
![plot](./img/complex/complex_digamma_plot.png) ![plot](./img/complex/complex_trigamma_plot.png)
### **Trigonometric functions**
- **Sine function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_trigonometry/complex_sin_plotter.java*") - Plot of sine function. Sine of complex numbers is done with equation from: *https://proofwiki.org/wiki/Sine_of_Complex_Number*.
- **Cosine function** ("src/lib/java/math/plotter/complex_function_plotter/complex_trigonometry/complex_cos_plotter.java*") - Plot of cosine function. Cosine of complex numbers is done with equation from: *https://proofwiki.org/wiki/Cosine_of_Complex_Number*.
- **Tangent function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_trigonometry/complex_tan_plotter.java*") - Plot of tangent function. Tangent of complex numbers is done with 3rd formulation from: *https://proofwiki.org/wiki/Tangent_of_Complex_Number*.
- **Cotagent function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_trigonometry/complex_cot_plotter.java*") - Plot of cotangent function. Cotangent of complex numbers is done with 3rd formulation from: *https://proofwiki.org/wiki/Cotangent_of_Complex_Number*. <br />
![plot](./img/complex/trigonometry/complex_sin_plot.png) ![plot](./img/complex/trigonometry/complex_cot_plot.png)
- **Secant function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_trigonometry/complex_sec_plotter.java*") - Plot of secant function. Secant of complex numbers is done with eqaution from: *https://proofwiki.org/wiki/Secant_of_Complex_Number*.
- **Cosecant function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_trigonometry/complex_csc_plotter.java*") - Plot of cosecant function. Cosecant of complex number is done with equation from: *https://proofwiki.org/wiki/Cosecant_of_Complex_Number*.
### **Hyperbolic function**
- **Hyperbolic sine function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_hyperbolic/complex_sinh_plotter.java*") - Plot of hyperbolic sine function. Hyperbolic sine of complex number is done with equation from: *https://proofwiki.org/wiki/Hyperbolic_Sine_of_Complex_Number*.
- **Hyperbolic cosine function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_hyperbolic/complex_cosh_plotter.java*") - Plot of hyperbolic cosine function. Hyperbolic cosine of complex number is done with equation from: *https://proofwiki.org/wiki/Hyperbolic_Cosine_of_Complex_Number*.
- **Hyperbolic tangent function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_hyperbolic/complex_tanh_plotter.java*") - Plot of hyperbolic tangent function. Hyperbolic tangent of complex number is done with 3rd formulation from: *https://proofwiki.org/wiki/Hyperbolic_Tangent_of_Complex_Number*.
- **Hyperbolic cotangent function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_hyperbolic/complex_tanh_plotter.java*") - Plot of hyperbolic cotangent function. Hyperbolic cotangent of complex number is done with 3rd formulation from: *https://proofwiki.org/wiki/Hyperbolic_Cotangent_of_Complex_Number*. <br />
![plot](./img/complex/hyperbolic/complex_sinh_plot.png) ![plot](img/complex/hyperbolic/complex_csch_plot.png)
- **Hyperbolic secant function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_hyperbolic/complex_sech_plotter.java*") - Plot of hyperbolic secant function. Hyperbolic secant of complex number is done with equation from: *https://proofwiki.org/wiki/Hyperbolic_Secant_of_Complex_Number*.
- **Hyperbolic cosecant function** ("*src/lib/java/math/plotter/complex_function_plotter/complex_hyperbolic/complex_csch_plotter.java*") - Plot of hyperbolic cosecant function. Hyperbolic cosecant of complex number is done with equation from: *https://proofwiki.org/wiki/Hyperbolic_Cosecant_of_Complex_Number*.
-->