# 在这记录一些工作中遇到的异常
### Caused by: java.lang.ClassCastException: org.apache.catalina.connector.RequestFacade cannot be cast to java.util.Map
#### 部分代码：
@Around("doWeb()&&doPageAlias(pageAlias)")
    public Object doAround(ProceedingJoinPoint pjp, PageAlias pageAlias) throws Throwable {
        Object result = pjp.proceed();
        Object[] args = pjp.getArgs();
        StringBuilder stringBuilder = new StringBuilder();
        if (args != null && args.length > 0) {
            Map<String, Object> model = (Map)pjp.getArgs()[0];

@PageAlias("repaymentSuccess")
    @RequestMapping("customer/borrowMoneyCallback")
    public String borrowMoneyCallbackUI(Model model,int productNo,String time,HttpServletRequest request){

#### 异常出现原因：
pjp.getArgs()[0] 这个方法，默认为肯定获取到model对象，结果新加参数时我把reqeust放在了第一位，导致获取不到model，所以报错。

---
