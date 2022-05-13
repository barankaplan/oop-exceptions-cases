package com.example.oopexceptionscases.case1;

/*----------------------------------------------------------------------------------------------------------------------
    05.12.2021
    Throwable sınıfının parametresiz printStackTrace metodu exception fıorlatılması noktalarını stack biçiminde gösteren
    detaylı mesajı ekrana basar. Bu metotta basılan yazı akış exception yakalanmadığından dolayı sonlandığında da
    basılan yazı ile neredeyse aynıdır. Bu metot da sanaldır gerekirse override edilebilir
----------------------------------------------------------------------------------------------------------------------*/


import org.csystem.util.console.Console;

class C1 {
    public static void main(String [] args)
    {
        try {
            double val = Console.readDouble("enter a number:", "not valid!:");

            double result = MathUtil.myLog(val);

            System.out.printf("log(%.2f) = %f%n", val, result);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }

    }
}


class MathUtil {
    public static double myLog(double val)
    {
        if (val == 0)
            throw new MathException("val can not be zero", MathExceptionStatus.ZERO);

        if (val < 0)
            throw new MathException("val can not be negative", MathExceptionStatus.NEGATIVE);

        return Math.log(val);
    }
}
//enum is a good way of  an efficient singleton implementation
//public static nesne referanslaridir her biri ilgili türden yaratilmistir
//bir nesnenin referansini tutarlar
enum MathExceptionStatus {ZERO, NEGATIVE}

class MathException extends RuntimeException {
    private final MathExceptionStatus m_status;

    public MathException(String message, MathExceptionStatus status)
    {
        super(message);
        m_status = status;
    }

    public String getMessage()
    {
        return String.format("Message:%s, Error Status:%s", super.getMessage(), getStatus());
    }

    public MathExceptionStatus getStatus()
    {
        return m_status;
    }
}

