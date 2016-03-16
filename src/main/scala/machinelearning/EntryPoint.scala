package machinelearning

import org.apache.spark._
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka._
import argonaut._, Argonaut._
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.mllib.regression.{LinearRegressionModel, GeneralizedLinearAlgorithm}
import org.apache.spark.mllib.optimization._
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.SparkConf
import org.apache.spark.mllib.linalg

import scala.util.Random._

case class UserClick(
  time: String,
  recency: Long,
  os: String,
  version: String,
  campain_id: Long,
  creative_width: Long,
  creative_height: Long,
  is_click: Long
)

//class StreamingLinearRegression (var d: Int,
//                                 var stepSize: Double,
//                                 var numIterations: Int,
//                                 var initializationMode: String) extends GeneralizedLinearAlgorithm[LinearRegressionModel] with Serializable {
//
//  val gradient = new LeastSquaresGradient()
//  val updater = new SimpleUpdater()
//  @transient val optimizer =  new GradientDescent(gradient, updater).setStepSize(stepSize)
//      .setNumIterations(numIterations)
//      .setMiniBatchFraction(1.0)
//
//  /** Construct a StreamingLinearRegression object with default parameters */
//  def this() = this(5, 1.0, 10, "fixed")
//
//  /** Set the number of features per data point (d). Default: 5
//    * TODO: if possible, set this automatically based on first data point
//    */
//  def setD(d: Int): StreamingLinearRegression = {
//    this.d = d
//    this
//  }
//
//  /**
//   * Set the initialization mode, either random (gaussian) or fixed.
//   * Default: fixed
//   */
//  def setInitializationMode(initializationMode: String): StreamingLinearRegression = {
//    if (initializationMode != "random" && initializationMode != "fixed") {
//      throw new IllegalArgumentException("Invalid initialization mode: " + initializationMode)
//    }
//    this.initializationMode = initializationMode
//    this
//  }
//
//  /** Create a Linear Regression model */
//  def createModel(weights: linalg.Vector, intercept: Double) = {
//    new LinearRegressionModel(weights, intercept)
//  }
//
//  /** Initialize a Linear Regression model with fixed weights */
//  def initFixed(): LinearRegressionModel = {
//    val weights = Vectors.dense(Array.fill(d)(1.0))
//    val intercept = 0.0
//    createModel(weights, intercept)
//  }
//
//  /** Initialize a Linear Regression model with random weights */
//  def initRandom(): LinearRegressionModel = {
//    val weights = Vectors.dense(Array.fill(d)(nextGaussian()))
//    val intercept = nextGaussian()
//    createModel(weights, intercept)
//  }
//
//  /** Update a Linear Regression model by running a gradient update */
//  def update(rdd: RDD[LabeledPoint], model: LinearRegressionModel): LinearRegressionModel = {
//    if (rdd.count() != 0) {
//      run(rdd, model.weights)
//    } else {
//      model
//    }
//  }
//
//  /** Main streaming operation: initialize the Linear Regression model
//    * and then update it based on new data from the stream.
//    */
//  def runStreaming(data: DStream[LabeledPoint]): DStream[Double] = {
//    var model = initFixed()
//    data.foreachRDD(rdd => model = update(rdd, model))
//    data.map(x => model.predict(x.features))
//  }
//}
//
//object EntryPoint {
//  implicit val codecUserClick =
//    casecodec8(UserClick.apply, UserClick.unapply)("time",
//          "recency",
//          "os",
//          "version",
//          "campaign_id",
//          "creative_width",
//          "creative_height",
//          "is_click")
//
//  def main(args: Array[String]): Unit = {
//    val conf = new SparkConf().setMaster("local[*]").setAppName("ML20160301")
//    val ssc = new StreamingContext(new SparkContext(conf), Seconds(30))
//    val kafkaStream = KafkaUtils.createStream(ssc, "", "", Map("1"->1), StorageLevel.DISK_ONLY)
//    kafkaStream.foreachRDD(rdd => {
//      rdd.collect()
//    })
//  }
//}
