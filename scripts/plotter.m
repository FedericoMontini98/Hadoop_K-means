% File CSV di input
csvFiles = {'data/dataset_test.csv', 'data/centroids_test.csv', 'data/results.csv'};

% Carica i dati dai file CSV
data = cell(1, 3);
for i = 1:3
    data{i} = readmatrix(csvFiles ...
        {i});
end

% Crea una figura
figure

% Traccia i dati
plot3(data{1}(:,1), data{1}(:,2), data{1}(:,3), 'bo','Linestyle','None')
hold on
plot3(data{2}(:,1), data{2}(:,2), data{2}(:,3), 'g^','Linestyle','None','MarkerFaceColor', 'g')
plot3(data{3}(:,1), data{3}(:,2), data{3}(:,3), 'rs','Linestyle','None','MarkerFaceColor', 'r')

% Aggiungi etichette e titolo al plot
xlabel('X');
ylabel('Y');
zlabel('Z');
title('Plot 3D dei punti');

% Mostra la griglia
grid on;

% Visualizza una legenda
legend('dataset_test', 'centroids_test', 'results');

% Imposta la visuale
view(3);