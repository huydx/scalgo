module TacosMachineLearning
  class TrainDat
    attr_accessor :features, :label
    def initialize(features, label)
      @features = features
      @label = label
    end
  end


  class Perceptron
    attr_reader :num_trains, :w

    def initialize(num_trains=1000, w = {})
      @num_trains = num_trains
      @w = w
    end

    def predict(dat)
			dat.features.reduce(0) do |a, f|
        k, x = f
        (@w[k]) ? y + (@w[k]*x) : y
			end
    end

    def train(fname)
      dats = read(fname)
      dats.each do |dat|
        if (y = predict?(dat))
          next if (y*dat.label) < 0
          update_weight(dat, y)
        end
      end
    end

    def read(fname)

    end

    def update_weight(dat, y)
      dat.features.each do |k, x|
        @w[k] += y * x
      end
    end
  end
end
