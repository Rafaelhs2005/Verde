#include <iostream>
#include <string>
using namespace std;

class relogio {
private:
    int hora;
    int minuto;
    int segundo;

public:
    relogio(int hora, int minuto, int segundo) {
        this->hora = hora;
        this->minuto = minuto;
        this->segundo = segundo;
    }

    int getHora() {
        return hora;
    }

    int getMinuto() {
        return minuto;
    }

    int getSegundo() {
        return segundo;
    }

    void setHora(int hora) {
        this->hora = hora;
    }

    void setMinuto(int minuto) {
        this->minuto = minuto;
    }

    void setSegundo(int segundo) {
        this->segundo = segundo;
    }

    void setHorario(int hora, int minuto, int segundo) {
        this->hora = hora;
        this->minuto = minuto;
        this->segundo = segundo;
    }

    string getHorario() {
        return to_string(hora) + ":" + to_string(minuto) + ":" + to_string(segundo);
    }

    void avancarHorario() {
        segundo++;
        if (segundo == 60) {
            segundo = 0;
            minuto++;
            if (minuto == 60) {
                minuto = 0;
                hora++;
                if (hora == 24) {
                    hora = 0;
                }
            }
        }
    }
};

int main() {
    relogio r(10, 0, 59);
    cout << r.getHorario() << endl;
    r.avancarHorario();
    cout << r.getHorario() << endl;
    r.setHorario(23, 59, 59);
    r.avancarHorario();
    cout << r.getHorario() << endl;

    return 0;
}
