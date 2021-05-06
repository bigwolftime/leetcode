package other.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {


    public static void main(String[] args) {
        ITest test = new Test();

        InvocationHandler handler = new other.dynamicproxy.Proxy(test);

        Proxy.newProxyInstance(test.getClass().getClassLoader(), test.getClass().getInterfaces(), handler);
    }


}
