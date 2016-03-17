require "pry"

module TacosMachineLearning
  class TrainDat
    attr_accessor :features, :label
    def initialize(features, label)
      @features = features
      @label = label
    end
  end


  class PerceptronMachine
    attr_reader :train, :num_trains, :w

    def initialize(num_trains=1000, w = [])
      @num_trains = num_trains
      @w = w
    end

    def predict(dat)
      dat.features.each_with_index.inject(0) do |y, (f, idx)|
        (@w[idx]) ? y + (@w[idx]*f) : y
      end
    end

    def train!(fname)
      dats = read!(fname)
      dats.each do |dat|
        y = predict(dat)
        next if (y*dat.label) < 0
        update_weight(dat, y)
      end
      self
    end

    def read!(fname)
      train = []

      File.open(fname) do |f|
        f.each do |line|
          arr = line.split(",")
          label = arr.pop
          label = if (label == "Iris-setosa") then 1 else -1 end
          arr = arr.map(&:to_i)
          train << TrainDat.new(arr, label)
        end
      end

      train
    end

    def update_weight(dat, y)
      dat.features.each_with_index do |f, idx|
        @w[idx] ||= 0
        @w[idx] += y * f
      end
    end
  end
end

machine = TacosMachineLearning::PerceptronMachine.new().train!("traindata.txt")
p machine
