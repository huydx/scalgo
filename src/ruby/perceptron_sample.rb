module MachineLearning
  class Perceptron
    attr_reader :w

    def initialize w={}
      @w = w
    end

    def predict vector_x
      vector_x.reduce(0) do |y, v|
        k, x = v
        (w[k]) ? y + (w[k]*x) : y
      end
    end

    def train vector_x, t
      y = predict(vector_x)
      return unless (y*t) < 0
      vector_x.each do |k, x|
        w[k] += t * x
      end
    end
  end
end

# 訓練データ
# 暖色 => 1
# 寒色 => -1
train_data = [
  [{:R => 255, :G => 0, :B => 0, :bias => 1}, 1],
  [{:R => 0, :G => 255, :B => 255, :bias => 1}, -1],
  [{:R => 0, :G => 255, :B => 0, :bias => 1}, -1],
  [{:R => 255, :G => 0, :B => 255, :bias => 1}, 1],
  [{:R => 0, :G => 0, :B => 255, :bias => 1}, -1],
  [{:R => 255, :G => 255, :B => 0, :bias => 1}, 1],
]

machine = MachineLearning::Perceptron.new({:R => 0, :G => 0, :B => 0, :bias => 1})

# 訓練パート
10.times do
  train_data.each do |x, t|
    machine.train(x, t)
  end
end

# 推定パート
puts "color codeを入力して下さい (例) 102 204 255"
while (print "> "; input = gets) do
  input = input.chomp.strip

  break if input == 'q'
  next unless input =~ /^\d{1,3} +\d{1,3} +\d{1,3}$/

  r,g,b = input.split(' ').map{|s| s.to_i}

  x = {:R => r, :G => g, :B => b, :bias => 1}
  t = machine.predict(x)
  case
    when t >= 0
      puts "=> 暖色 [#{t}]"
    else
      puts "=> 寒色 [#{t}]"
  end
end
