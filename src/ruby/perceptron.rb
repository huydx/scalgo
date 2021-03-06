module TacosMachineLearning
  class TrainDat
    attr_accessor :features, :label
    def initialize(features, label)
      @features = features
      @label = label
    end
  end


  class PerceptronMachine
    attr_reader :train, :num_trains, :w, :threshold

    def initialize(num_trains=10000, w = [], threshold = 0.0)
      @num_trains = num_trains
      @w = w
      @threshold = threshold
    end

    def predict(dat)
      sum = dat.features.each_with_index.inject(0) do |y, (f, idx)|
        @w[idx] ||= 1
        y + (@w[idx]*f)
      end

      if sum > @threshold
        return 1
      else
        return -1
      end
    end

    def train!(dats)
      dats.each do |dat|
        y = predict(dat)
        next if (y*dat.label) > 0
        update_weight(dat, dat.label)
      end
      self
    end

    def loop_train!(fname)
      dats = read(fname)
      (1..@num_trains).each do |i|
        train!(dats)
      end
      self
    end

    def read(fname)
      train = []

      File.open(fname) do |f|
        f.each do |line|
          arr = line.strip!.split(",")
          label = arr.pop
          label = if (label == "Iris-setosa") then 1 else -1 end
          arr = arr.map(&:to_f)
          train << TrainDat.new(arr, label)
        end
      end

      train
    end

    def update_weight(dat, y)
      c = 0.5
      dat.features.each_with_index do |f, idx|
        @w[idx] ||= 1
        jump =  c * y * f
        @w[idx] += jump
      end
    end
  end
end

machine = TacosMachineLearning::PerceptronMachine.new().loop_train!("traindata.txt")

##test
dats = machine.read("traindata.txt")
correct = 0
dats.each do |dat|
  predict = machine.predict(dat)
  correct += 1 if predict == dat.label
end

p "correct prob : #{(correct / dats.length)*100} %"
