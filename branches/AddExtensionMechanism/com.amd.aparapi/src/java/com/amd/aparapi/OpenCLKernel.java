package com.amd.aparapi;

import java.util.List;

public class OpenCLKernel{
   private Arg[] args;

   private long kernelId;

   private Program program;

   private String name;

   OpenCLKernel(long _kernelId, Program _program, String _name, List<Arg> _args) {
      kernelId = _kernelId;
      program = _program;
      name = _name;
      args = _args.toArray(new Arg[0]);
      for (Arg arg : args) {
         arg.kernel = this;
      }
   }

   public String getName() {
      return name;
   }

   public void invoke(Object[] _args) {
      OpenCLJNI.getJNI().invoke(this, _args);

   }

}
