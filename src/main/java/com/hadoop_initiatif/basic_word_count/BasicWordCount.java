package com.hadoop_initiatif.basic_word_count;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * classe copiée depuis le tutoriel d'apache pour tester l'environnement de développement 
 * et l'environnement de déployement hadoop.
 * 
 * Environnement de développement :
 * jdk 1.8
 * git 1.3
 * maven 3.5
 * eclipse IDE for Java
 * hadoop 2.9
 * 
 * Environnement de déployement basique :
 * apache hadoop 2.9
 * 
 * Environnement de déployement avancé :
 * Docker
 * Image Cloudera ou Mapr verion standard (gratuit), ou installation mannuel.
 * 
 * @author Jeremie LOU
 *
 */
public class BasicWordCount {

	  public static class TokenizerMapper
	       extends Mapper<Object, Text, Text, IntWritable>{

	    private final static IntWritable one = new IntWritable(1);
	    private Text word = new Text();

	    public void map(Object key, Text value, Context context
	                    ) throws IOException, InterruptedException {
	      StringTokenizer itr = new StringTokenizer(value.toString());
	      while (itr.hasMoreTokens()) {
	        word.set(itr.nextToken());
	        context.write(word, one);
	      }
	    }
	  }

	  public static class IntSumReducer
	       extends Reducer<Text,IntWritable,Text,IntWritable> {
	    private IntWritable result = new IntWritable();

	    public void reduce(Text key, Iterable<IntWritable> values,
	                       Context context
	                       ) throws IOException, InterruptedException {
	      int sum = 0;
	      for (IntWritable val : values) {
	        sum += val.get();
	      }
	      result.set(sum);
	      context.write(key, result);
	    }
	  }

	  public static void main(String[] args) throws Exception {
	    Configuration conf = new Configuration();
	    Job job = Job.getInstance(conf, "word count");
	    job.setJarByClass(BasicWordCount.class);
	    job.setMapperClass(TokenizerMapper.class);
	    job.setCombinerClass(IntSumReducer.class);
	    job.setReducerClass(IntSumReducer.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	  }
	}
